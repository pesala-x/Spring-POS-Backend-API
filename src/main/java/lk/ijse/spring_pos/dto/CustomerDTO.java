package lk.ijse.spring_pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable {
    private String customerId;
    private String firstName;
    private String lastName;
    private String name;
    private String address;
    private String email;
    private int mobile;
    private LocalDateTime registerDateTime;
}
