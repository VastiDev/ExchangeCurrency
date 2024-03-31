package com.example.exchange.currencypair.infra;

import com.example.exchange.currencypair.application.api.CurrencyPairDetailedResponse;
import com.example.exchange.currencypair.application.service.CurrencyPairRepository;
import com.example.exchange.currencypair.domain.CurrencyPair;
import com.example.exchange.handler.APIException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CurrencyPairInfraRepository implements CurrencyPairRepository {
    private final CurrencyPairSpringDataJpaRepository currencyPairSpringDataJpaRepository;

    @Override
    public CurrencyPair savePair(CurrencyPair currencyPair) {
        currencyPairSpringDataJpaRepository.save(currencyPair);
        return currencyPair;
    }

    @Override
    public CurrencyPair getPairById(UUID id) {
        CurrencyPair currencyPair = currencyPairSpringDataJpaRepository.findById(id)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND,
                        "Id not found"));
        return currencyPair;
    }


}
