package com.example.exchange.exchangerate.application.api;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface ExchangeRateService {

    ExchangeRateResponse insertRate(ExchangeRateRequest exchangeRateRequest, UUID idPair);
}
