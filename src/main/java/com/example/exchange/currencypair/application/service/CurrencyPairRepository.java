package com.example.exchange.currencypair.application.service;

import com.example.exchange.currencypair.domain.CurrencyPair;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CurrencyPairRepository {
    CurrencyPair savePair(CurrencyPair currencyPair);

    CurrencyPair getPairById(UUID id);
}
