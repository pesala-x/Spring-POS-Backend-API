package lk.ijse.spring_pos.service;

import lk.ijse.spring_pos.customObj.CustomerResponse;
import lk.ijse.spring_pos.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    String saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String id);
    CustomerResponse getCustomerById(String id);
    List<CustomerDTO> getAllCustomers();
}
