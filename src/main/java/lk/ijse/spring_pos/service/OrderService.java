package lk.ijse.spring_pos.service;

import lk.ijse.spring_pos.dto.OrderDTO;

public interface OrderService {
    String saveOrder(OrderDTO orderDTO);
}
