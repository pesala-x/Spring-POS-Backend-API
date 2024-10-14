package lk.ijse.spring_pos.service.impl;

import lk.ijse.spring_pos.customObj.CustomerResponse;
import lk.ijse.spring_pos.dao.CustomerDAO;
import lk.ijse.spring_pos.dto.CustomerDTO;
import lk.ijse.spring_pos.service.CustomerService;
import lk.ijse.spring_pos.util.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private final CustomerDAO customerDAO;

    @Autowired
    private final MappingUtil mappingUtil;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        return "";
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }
}
