package com.example.exchange.currencypair.domain;

import com.example.exchange.currencypair.application.api.CurrencyPairRequest;
import com.example.exchange.exchangerate.domain.ExchangeRate;
import com.example.exchange.handler.APIException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.http.HttpStatus;

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
    private UUID idPair;
    @NotBlank
    private String baseCurrency;
    @NotBlank
    private String targetCurrency;
    private LocalDateTime requestLocalDateTime;

    @OneToOne(mappedBy = "currencyPair", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private ExchangeRate exchangeRate;

    public CurrencyPair(CurrencyPairRequest currencyPairRequest){
        this.baseCurrency = currencyPairRequest.getBaseCurrency().toUpperCase();
        this.targetCurrency = currencyPairRequest.getTargetCurrency().toUpperCase();
        validateCurrencyPair();
    }

    public void validateCurrencyCode(String currencyCode) {
        if (currencyCode == null || currencyCode.length() != 3 || !currencyCode.equals(currencyCode.toUpperCase())) {
            throw (APIException.build(HttpStatus.BAD_REQUEST,"A moeda deve conter 3 letras maiúsculas."));
        }
    }

    public void validateCurrencyPair() {
        validateCurrencyCode(this.baseCurrency);
        validateCurrencyCode(this.targetCurrency);
    }

}


