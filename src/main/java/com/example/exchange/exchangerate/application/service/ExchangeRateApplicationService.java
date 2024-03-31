package com.example.exchange.exchangerate.application.service;

import com.example.exchange.communication.api.ExternalExchangeRateData;
import com.example.exchange.communication.service.ExternalExchangeRateService;
import com.example.exchange.currencypair.application.api.CurrencyPairDetailedResponse;
import com.example.exchange.currencypair.application.api.CurrencyPairService;
import com.example.exchange.currencypair.domain.CurrencyPair;
import com.example.exchange.currencypair.infra.CurrencyPairInfraRepository;
import com.example.exchange.exchangerate.application.api.ExchangeRateRequest;
import com.example.exchange.exchangerate.application.api.ExchangeRateResponse;
import com.example.exchange.exchangerate.application.api.ExchangeRateService;
import com.example.exchange.exchangerate.domain.ExchangeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExchangeRateApplicationService implements ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExternalExchangeRateService externalExchangeRate;
    private final CurrencyPairInfraRepository currencyPairInfraRepository;


    @Override
    public ExchangeRateResponse insertRate(ExchangeRateRequest exchangeRateRequest, UUID idPair) {

        CurrencyPair currencyPair = currencyPairInfraRepository.getPairById(idPair);
        if(currencyPair ==  null){
            throw new RuntimeException("o idPair está nulo!");
        }
        var bidOptional = externalExchangeRate.fetchExternalExchangeRate(currencyPair.getBaseCurrency(),
                currencyPair.getTargetCurrency());


        if (bidOptional.isEmpty()) {
            throw new RuntimeException("Não foi possível buscar a taxa de câmbio.");
        }

        ExternalExchangeRateData rateData = bidOptional.get();
        BigDecimal bid = rateData.getBid();

        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrencyPair(currencyPair);
        exchangeRate.setBid(bid);
        exchangeRate.setTimestamp(LocalDateTime.now());
        exchangeRate.setAmount(exchangeRateRequest.getAmount());

        exchangeRateRepository.saveRate(exchangeRate);


        BigDecimal convertedAmount = exchangeRateRequest.getAmount().multiply(bid);
        String message = exchangeRateRequest.getAmount() + " " + currencyPair.getBaseCurrency() + " = " + convertedAmount + " "
                + currencyPair.getTargetCurrency();

        return new ExchangeRateResponse(exchangeRate.getIdExchange(), bid, convertedAmount, message, exchangeRate.getTimestamp());
    }
}
