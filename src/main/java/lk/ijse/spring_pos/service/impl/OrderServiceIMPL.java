package lk.ijse.spring_pos.service.impl;

import lk.ijse.spring_pos.dao.ItemDAO;
import lk.ijse.spring_pos.dao.OrderDAO;
import lk.ijse.spring_pos.dto.OrderDTO;
import lk.ijse.spring_pos.dto.OrderDetailDTO;
import lk.ijse.spring_pos.entity.ItemEntity;
import lk.ijse.spring_pos.entity.OrderDetailEntity;
import lk.ijse.spring_pos.entity.OrderEntity;
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
        orderDTO.getOrderDetails().forEach(orderDetailDTO -> {
            if (!updateItemQty(orderDetailDTO)) {
                throw new RuntimeException("Failed to update stock for item: " + orderDetailDTO.getItemCode());
            }
        });

        orderDTO.setOrderId(generateOrderID());
        orderDTO.setOrderDateTime(DateTimeUtil.getCurrentDateTime());
        orderDTO.setTotal(orderDTO.getOrderDetails().stream().mapToDouble(orderDetailDTO -> orderDetailDTO.getQty() * orderDetailDTO.getUnitPrice()).sum());
        OrderEntity orderEntity = mappingUtil.convertToOrderEntity(orderDTO);

        List<OrderDetailEntity> orderDetailEntities = orderDTO.getOrderDetails().stream().map(detail -> {
                    OrderDetailEntity orderDetailEntity = mappingUtil.convertToOrderDetailEntity(detail);
                    orderDetailEntity.setOrder(orderEntity);
                    return orderDetailEntity;
                })
                .collect(Collectors.toList());

        orderEntity.setOrderDetails(orderDetailEntities);

        orderDAO.save(orderEntity);
        return "Place order successfully";
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
            System.out.println("Item not found: " + orderDetailDTO.getItemCode());
            return false;
        }

        if (item.getQtyOnHand() < orderDetailDTO.getQty()) {
            System.out.println("Not enough stock for item: " + orderDetailDTO.getItemCode());
            return false;
        }

        item.setQtyOnHand(item.getQtyOnHand() - orderDetailDTO.getQty());
        itemDAO.save(item);
        return true;
    }



}
