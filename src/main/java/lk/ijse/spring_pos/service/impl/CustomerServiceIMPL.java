package lk.ijse.spring_pos.service.impl;

import lk.ijse.spring_pos.customObj.CustomerResponse;
import lk.ijse.spring_pos.customObj.impl.CustomerErrorResponse;
import lk.ijse.spring_pos.dao.CustomerDAO;
import lk.ijse.spring_pos.dto.CustomerDTO;
import lk.ijse.spring_pos.entity.CustomerEntity;
import lk.ijse.spring_pos.service.CustomerService;
import lk.ijse.spring_pos.util.DateTimeUtil;
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
        customerDTO.setCustomerId(generateCustomerID());
        customerDTO.setName(customerDTO.getFirstName() + " " + customerDTO.getLastName());
        customerDTO.setLastUpdatedAt(DateTimeUtil.getCurrentDateTime());
        CustomerEntity customerEntity = mappingUtil.convertToCustomerEntity(customerDTO);
        customerDAO.save(customerEntity);
        System.out.println("Customer saved : " + customerEntity);
        return "Customer saved successfully";
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        if (customerDAO.existsById(id)) {
            CustomerEntity customerEntity = customerDAO.getReferenceById(id);
            System.out.println("Customer found : " + customerEntity);
            CustomerDTO customerDTO = mappingUtil.convertToCustomerDTO(customerEntity);
            customerDTO.setFirstName(customerDTO.getName().split(" ")[0]);
            customerDTO.setLastName(customerDTO.getName().split(" ")[1]);
            return customerDTO;
        } else {
            System.out.println("Customer not found");
            return new CustomerErrorResponse(0, "Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    private String generateCustomerID() {
        if (customerDAO.count() == 0) {
            return "C001";
        } else {
            String lastId = customerDAO.findAll().get(customerDAO.findAll().size() - 1).getCustomerId();
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            if (newId < 10) {
                return "C00" + newId;
            } else if (newId < 100) {
                return "C0" + newId;
            } else {
                return "C" + newId;
            }
        }
    }
}
