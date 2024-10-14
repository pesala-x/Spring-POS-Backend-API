package lk.ijse.spring_pos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String name;
    private String address;
    private String email;
    private int mobile;
    private LocalDate registerDate;
}
