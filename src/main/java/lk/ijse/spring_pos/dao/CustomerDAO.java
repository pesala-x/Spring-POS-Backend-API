package lk.ijse.spring_pos.dao;

import lk.ijse.spring_pos.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity, String> { }
