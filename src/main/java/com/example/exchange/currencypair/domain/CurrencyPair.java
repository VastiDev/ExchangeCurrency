package com.example.exchange.currencypair.domain;

import com.example.exchange.currencypair.application.api.CurrencyPairRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@NoArgsConstructor
public class CurrencyPair {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_currency_pair", updatable = false, nullable = false)
    private UUID id;
    @NotBlank
    private String baseCurrency;
    @NotBlank
    private String targetCurrency;
    private LocalDateTime requestLocalDateTime;

    public CurrencyPair(CurrencyPairRequest currencyPairRequest){
        this.baseCurrency = currencyPairRequest.getBaseCurrency();
        this.targetCurrency = currencyPairRequest.getTargetCurrency();
    }

}


