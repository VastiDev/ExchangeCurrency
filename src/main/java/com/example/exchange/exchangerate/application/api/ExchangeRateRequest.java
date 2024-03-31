package com.example.exchange.exchangerate.application.api;

;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

public class ExchangeRateRequest {
    private BigDecimal amount;

    @JsonCreator
    public ExchangeRateRequest(@JsonProperty("amount") BigDecimal amount) {
        this.amount = amount;
    }
}
