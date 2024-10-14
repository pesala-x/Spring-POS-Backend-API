package lk.ijse.spring_pos.util;

import lk.ijse.spring_pos.dto.CustomerDTO;
import lk.ijse.spring_pos.entity.CustomerEntity;
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
}
