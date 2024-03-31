package com.example.exchange.exchangerate.domain;

import com.example.exchange.currencypair.domain.CurrencyPair;
import com.example.exchange.exchangerate.application.api.ExchangeRateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_exchange", updatable = false, nullable = false)
    private UUID idExchange;
    private BigDecimal bid;
    private LocalDateTime timestamp;
    private BigDecimal amount;
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_currency_pair")
    private CurrencyPair currencyPair;
}
