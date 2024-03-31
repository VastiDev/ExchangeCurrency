package com.example.exchange.exchangerate.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ExchangeRateController implements ExchangeRateApi {
    private final ExchangeRateService exchangeRateService;

    @Override
    public ExchangeRateResponse postRate(ExchangeRateRequest exchangeRateRequest, UUID idPair) {
        ExchangeRateResponse rateResponse = exchangeRateService.insertRate(exchangeRateRequest, idPair);
        return rateResponse;
    }
}
