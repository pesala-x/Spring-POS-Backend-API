package lk.ijse.spring_pos.service.impl;

import lk.ijse.spring_pos.dao.ItemDAO;
import lk.ijse.spring_pos.dao.OrderDAO;
import lk.ijse.spring_pos.dto.OrderDTO;
import lk.ijse.spring_pos.dto.OrderDetailDTO;
import lk.ijse.spring_pos.entity.ItemEntity;
import lk.ijse.spring_pos.entity.OrderDetailEntity;
import lk.ijse.spring_pos.entity.OrderEntity;
import lk.ijse.spring_pos.exception.DataPersistFailedException;
import lk.ijse.spring_pos.exception.ItemNotFoundException;
import lk.ijse.spring_pos.service.OrderService;
import lk.ijse.spring_pos.util.DateTimeUtil;
import lk.ijse.spring_pos.util.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private final OrderDAO orderDAO;

    @Autowired
    private final ItemDAO itemDAO;

    @Autowired
    private final MappingUtil mappingUtil;

    @Override
    public String saveOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(generateOrderID());
        orderDTO.setOrderDateTime(DateTimeUtil.getCurrentDateTime());
        orderDTO.setTotal(orderDTO.getOrderDetails().stream().mapToDouble(detail -> detail.getQty() * detail.getUnitPrice()).sum());
        OrderEntity orderEntity = mappingUtil.convertToOrderEntity(orderDTO);

        List<OrderDetailEntity> orderDetailEntities = orderDTO.getOrderDetails().stream().map(detail -> {
                    OrderDetailEntity orderDetailEntity = mappingUtil.convertToOrderDetailEntity(detail);
                    orderDetailEntity.setDescription("Payment Verified");
                    orderDetailEntity.setOrder(orderEntity);
                    return orderDetailEntity;
                })
                .collect(Collectors.toList());

        orderEntity.setOrderDetails(orderDetailEntities);
        boolean allItemsUpdated = orderDTO.getOrderDetails().stream().allMatch(this::updateItemQty);

        if (allItemsUpdated) {
            orderDAO.save(orderEntity);
            return "Order placed successfully";
        } else {
            throw new DataPersistFailedException("place order failed");
        }
    }

    private String generateOrderID() {
        if (orderDAO.count() == 0) {
            return "O001";
        } else {
            String lastId = orderDAO.findAll().get(orderDAO.findAll().size() - 1).getOrderId();
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            if (newId < 10) {
                return "O00" + newId;
            } else if (newId < 100) {
                return "O0" + newId;
            } else {
                return "O" + newId;
            }
        }
    }

    private boolean updateItemQty(OrderDetailDTO orderDetailDTO) {
        ItemEntity item = itemDAO.findById(orderDetailDTO.getItemCode()).orElse(null);
        if (item == null) {
            throw new ItemNotFoundException("Item not found");
        }

        if (item.getQtyOnHand() < orderDetailDTO.getQty()) {
            throw new ItemNotFoundException("Item qty not enough");
        }

        item.setQtyOnHand(item.getQtyOnHand() - orderDetailDTO.getQty());
        itemDAO.save(item);
        return true;
    }
}
