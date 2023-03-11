package com.nv.aritmeticalcalculatorapi.domain.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String name;
    private String password;
}
