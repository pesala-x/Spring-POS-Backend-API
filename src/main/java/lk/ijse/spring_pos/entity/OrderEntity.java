package lk.ijse.spring_pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class OrderEntity implements Serializable {
    @Id
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private CustomerEntity customer;
    private LocalDateTime orderDateTime;
    private double orderTotal;
    private String paymentMethod;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetails;
}
