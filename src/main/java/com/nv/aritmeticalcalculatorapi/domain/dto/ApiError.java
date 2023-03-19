package com.nv.aritmeticalcalculatorapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    @JsonProperty("status_code")
    private Integer statusCode;
    private String status;
    private String message;
}
