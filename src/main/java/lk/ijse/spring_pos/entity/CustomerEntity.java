package lk.ijse.spring_pos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
@Entity
public class CustomerEntity implements Serializable {
    @Id
    private String customerId;
    private String name;
    private String address;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private int mobile;
    private LocalDateTime registerDateTime;
}

