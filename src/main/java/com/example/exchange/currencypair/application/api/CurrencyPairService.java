package com.example.exchange.currencypair.application.api;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CurrencyPairService {
    CurrencyPairResponse postCurrencyPair(CurrencyPairRequest currencyPairRequest);

    CurrencyPairDetailedResponse getPairById(UUID id);
}
