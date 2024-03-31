package com.example.exchange.exchangerate.application.api;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ExchangeRateResponse {
    private UUID idExchange;
    private BigDecimal bid;
    private BigDecimal convertedAmount;
    private String message;
    private LocalDateTime timestamp;
}
