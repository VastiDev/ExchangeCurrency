package com.example.exchange.currencypair.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyPairAPIController implements CurrencyPairAPI {
    private final CurrencyPairService currencyPairService;

    @Override
    public CurrencyPairResponse postCurrencyPair(CurrencyPairRequest currencyPairRequest) {
        CurrencyPairResponse pairCreated = currencyPairService.postCurrencyPair(currencyPairRequest);
        return pairCreated;
    }
}
