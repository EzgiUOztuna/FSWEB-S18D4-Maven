package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BurgerErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;

    public BurgerErrorResponse(String message)
    {
        this.message = message;
        timestamp = System.currentTimeMillis();
    }
}
