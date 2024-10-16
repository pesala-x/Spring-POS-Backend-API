package lk.ijse.spring_pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderDetailEntity implements Serializable {
    @Id
    private String orderDetailId;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "itemCode")
    private ItemEntity item;
    private int qty;
    private double unitPrice;
    private double total;
}
