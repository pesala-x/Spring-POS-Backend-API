package lk.ijse.spring_pos.dto;

import jakarta.validation.constraints.*;
import lk.ijse.spring_pos.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements Serializable, ItemResponse {
    private String itemCode;
    @NotBlank(message = "Category cannot be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Category must contain only letters")
    private String category;
    @Positive(message = "Unit price must be greater than zero")
    private double unitPrice;
    @Min(value = 1, message = "Quantity on hand cannot be negative")
    private int qtyOnHand;
    private LocalDate registerDate;
    @Future(message = "Expire date must be in the future")
    @NotNull(message = "Expire date cannot be null")
    private LocalDate expireDate;
}
