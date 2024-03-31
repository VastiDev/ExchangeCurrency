package com.example.exchange.exchangerate.application.infra;

import com.example.exchange.exchangerate.domain.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExchangeRateSpringDataJpaRepository extends JpaRepository <ExchangeRate, UUID> {
}
