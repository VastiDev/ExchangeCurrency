package com.example.exchange.currencypair.application.api;

import com.example.exchange.currencypair.domain.CurrencyPair;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CurrencyPairDetailedResponse {

    private String baseCurrency;
    private String targetCurrency;
    private LocalDateTime requestLocalDateTime;
    public CurrencyPairDetailedResponse(CurrencyPair currencyPair) {
        this.baseCurrency = currencyPair.getBaseCurrency();
        this.targetCurrency = currencyPair.getTargetCurrency();
        this.requestLocalDateTime = LocalDateTime.now();

    }
}
