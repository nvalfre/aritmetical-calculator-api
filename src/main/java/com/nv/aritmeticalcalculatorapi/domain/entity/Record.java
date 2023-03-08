package com.nv.aritmeticalcalculatorapi.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal amount;
    private BigDecimal userBalance;
    private String operationResponse;
    private LocalDateTime date;
    private boolean deleted;

    public Record(Operation operation, User user, BigDecimal amount, BigDecimal userBalance, BigDecimal operationResponse) {
        this.operation = operation;
        this.user = user;
        this.amount = amount;
        this.userBalance = userBalance;
        this.operationResponse = String.valueOf(operationResponse);
        this.date = LocalDateTime.now();
    }

    public Record(Operation operation, User user, BigDecimal amount, BigDecimal userBalance, String operationResponse) {
        this.operation = operation;
        this.user = user;
        this.amount = amount;
        this.userBalance = userBalance;
        this.operationResponse = operationResponse;
        this.date = LocalDateTime.now();
    }
}
