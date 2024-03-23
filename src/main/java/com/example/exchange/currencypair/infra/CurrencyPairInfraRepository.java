package com.example.exchange.currencypair.infra;

import com.example.exchange.currencypair.application.service.CurrencyPairRepository;
import com.example.exchange.currencypair.domain.CurrencyPair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CurrencyPairInfraRepository implements CurrencyPairRepository {
    private final CurrencyPairSpringDataJpaRepository currencyPairSpringDataJpaRepository;

    @Override
    public CurrencyPair savePair(CurrencyPair currencyPair) {
        currencyPairSpringDataJpaRepository.save(currencyPair);
        return currencyPair;
    }
}
