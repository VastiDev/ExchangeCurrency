package com.example.exchange.currencypair.application.api;

import org.springframework.stereotype.Service;

@Service
public interface CurrencyPairService {
    CurrencyPairResponse postCurrencyPair(CurrencyPairRequest currencyPairRequest);
}
