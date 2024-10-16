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
    private String category;
    private double unitPrice;
    private int qtyOnHand;
    private LocalDate registerDate;
    private LocalDate expireDate;
}
