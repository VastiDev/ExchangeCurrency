package com.example.exchange.currencypair.application.service;

import com.example.exchange.currencypair.application.api.CurrencyPairRequest;
import com.example.exchange.currencypair.application.api.CurrencyPairResponse;
import com.example.exchange.currencypair.application.api.CurrencyPairService;
import com.example.exchange.currencypair.domain.CurrencyPair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyPairApplicationService implements CurrencyPairService {
    private final CurrencyPairRepository currencyPairRepository;

    @Override
    public CurrencyPairResponse postCurrencyPair(CurrencyPairRequest currencyPairRequest) {
        CurrencyPair currencyPair = currencyPairRepository.savePair(new CurrencyPair(currencyPairRequest));
        return new CurrencyPairResponse(currencyPair.getId());
    }
}
