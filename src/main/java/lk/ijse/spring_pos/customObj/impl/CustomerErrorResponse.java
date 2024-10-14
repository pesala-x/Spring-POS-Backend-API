package lk.ijse.spring_pos.customObj.impl;

import lk.ijse.spring_pos.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerErrorResponse implements CustomerResponse,Serializable {
    private int errorCode;
    private String errorMessage;
}
