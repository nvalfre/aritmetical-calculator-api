package com.nv.aritmeticalcalculatorapi.domain.entity;

import com.nv.aritmeticalcalculatorapi.domain.enums.OperationType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    private BigDecimal cost;
}
