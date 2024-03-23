package com.example.exchange.currencypair.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Value
public class CurrencyPairRequest {
    private String baseCurrency;
    private String targetCurrency;

}
