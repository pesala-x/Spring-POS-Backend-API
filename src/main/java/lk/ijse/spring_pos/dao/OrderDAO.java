package lk.ijse.spring_pos.dao;

import lk.ijse.spring_pos.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, String> {}
