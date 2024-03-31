package com.example.exchange.exchangerate.application.service;

import com.example.exchange.exchangerate.domain.ExchangeRate;

public interface ExchangeRateRepository {
    ExchangeRate saveRate(ExchangeRate exchangeRate);
}
