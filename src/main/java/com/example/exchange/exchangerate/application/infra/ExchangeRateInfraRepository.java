package com.example.exchange.exchangerate.application.infra;

import com.example.exchange.exchangerate.application.service.ExchangeRateRepository;
import com.example.exchange.exchangerate.domain.ExchangeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExchangeRateInfraRepository implements ExchangeRateRepository {
    private final ExchangeRateSpringDataJpaRepository exchangeRateSpringDataJpaRepository;

    @Override
    public ExchangeRate saveRate(ExchangeRate exchangeRate) {
    exchangeRateSpringDataJpaRepository.save(exchangeRate);
    return exchangeRate;
    }
}
