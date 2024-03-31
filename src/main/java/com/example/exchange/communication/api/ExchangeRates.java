package com.example.exchange.communication.api;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRates {
    private Map<String, ExternalExchangeRateData> rates;

    @JsonAnySetter
    public void setRate(String key, ExternalExchangeRateData value) {
        if (rates == null) {
            rates = new HashMap<>();
        }
        rates.put(key, value);
    }

    public ExternalExchangeRateData getRate(String key) {
        return rates.get(key);
    }
}
