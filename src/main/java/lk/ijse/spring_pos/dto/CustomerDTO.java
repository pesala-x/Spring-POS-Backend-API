package lk.ijse.spring_pos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lk.ijse.spring_pos.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable, CustomerResponse {
    private String customerId;
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "First name must contain only alphabets and be 2-30 characters long")
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Last name must contain only alphabets and be 2-30 characters long")
    private String lastName;
    private String name;
    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    private String address;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    private int mobile;
    private LocalDateTime lastUpdatedAt;
}
