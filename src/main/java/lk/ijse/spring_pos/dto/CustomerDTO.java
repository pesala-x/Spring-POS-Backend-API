package lk.ijse.spring_pos.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    @Id
    private String customerId;
    private String name;
    private String address;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private int mobile;
    private LocalDate registerDate;
}
