package lk.ijse.spring_pos.dto;

import lk.ijse.spring_pos.customObj.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements Serializable, OrderResponse {
    private String orderId;
    private String customerId;
    private List<OrderDetailDTO> orderDetails;
    private LocalDateTime orderDateTime;
    private double total;
    private String paymentMethod;
}
