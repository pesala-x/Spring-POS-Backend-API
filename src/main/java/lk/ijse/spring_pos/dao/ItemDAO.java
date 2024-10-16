package lk.ijse.spring_pos.dao;


import lk.ijse.spring_pos.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<ItemEntity, String> {}
