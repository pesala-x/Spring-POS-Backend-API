package lk.ijse.spring_pos.dto;

import lk.ijse.spring_pos.customObj.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements Serializable, OrderResponse {
    private String orderId;
    private String customerId;
    private LocalDateTime orderDateTime;
    private double orderTotal;
    private String paymentMethod;
}
