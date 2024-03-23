package com.example.exchange.currencypair.application.service;

import com.example.exchange.currencypair.domain.CurrencyPair;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyPairRepository {
    CurrencyPair savePair(CurrencyPair currencyPair);
}
