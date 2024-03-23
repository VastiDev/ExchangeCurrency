package com.example.exchange.currencypair.infra;

import com.example.exchange.currencypair.domain.CurrencyPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CurrencyPairSpringDataJpaRepository extends JpaRepository<CurrencyPair, UUID> {
}
