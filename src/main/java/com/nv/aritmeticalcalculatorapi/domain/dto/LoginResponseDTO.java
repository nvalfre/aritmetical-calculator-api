package com.nv.aritmeticalcalculatorapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginResponseDTO {
    private String id;
    private String token;
    private boolean isActive;
    private String name;
}
