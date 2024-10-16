package lk.ijse.spring_pos.util;

import lk.ijse.spring_pos.dto.CustomerDTO;
import lk.ijse.spring_pos.dto.ItemDTO;
import lk.ijse.spring_pos.dto.OrderDTO;
import lk.ijse.spring_pos.dto.OrderDetailDTO;
import lk.ijse.spring_pos.entity.CustomerEntity;
import lk.ijse.spring_pos.entity.ItemEntity;
import lk.ijse.spring_pos.entity.OrderDetailEntity;
import lk.ijse.spring_pos.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingUtil {
    @Autowired
    private ModelMapper modelMapper;

    //mapping by customer entity & dto
    public CustomerDTO convertToCustomerDTO(CustomerEntity entity){
        return modelMapper.map(entity, CustomerDTO.class);
    }

    public CustomerEntity convertToCustomerEntity(CustomerDTO dto){
        return modelMapper.map(dto, CustomerEntity.class);
    }

    public List<CustomerDTO> convertToCustomerDTOList(List<CustomerEntity> entities){
        return modelMapper.map(entities, List.class);
    }

    //mapping by item entity & dto
    public ItemDTO convertToItemDTO(ItemEntity entity){
        return modelMapper.map(entity, ItemDTO.class);
    }

    public ItemEntity convertToItemEntity(ItemDTO dto){
        return modelMapper.map(dto, ItemEntity.class);
    }

    public List<ItemDTO> convertToItemDTOList(List<ItemEntity> entities){
        return modelMapper.map(entities, List.class);
    }

    //mapping by order entity & dto
    public OrderDTO convertToOrderDTO(OrderEntity entity){
        return modelMapper.map(entity, OrderDTO.class);
    }

    public OrderEntity convertToOrderEntity(OrderDTO dto){
        return modelMapper.map(dto, OrderEntity.class);
    }

    public List<OrderDTO> convertToOrderDTOList(List<OrderEntity> entities){
        return modelMapper.map(entities, List.class);
    }

    //mapping by order details entity & dto
    public OrderDetailDTO convertToOrderDetailDTO(OrderDetailEntity entity){
        return modelMapper.map(entity, OrderDetailDTO.class);
    }

    public OrderDetailEntity convertToOrderDetailEntity(OrderDetailDTO dto){
        return modelMapper.map(dto, OrderDetailEntity.class);
    }

    public List<OrderDetailDTO> convertToOrderDetailDTOList(List<OrderDetailEntity> entities){
        return modelMapper.map(entities, List.class);
    }
}
