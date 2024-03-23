package com.example.exchange.currencypair.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/currencyPair")
public interface CurrencyPairAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CurrencyPairResponse postCurrencyPair (@Valid
                                           @RequestBody CurrencyPairRequest currencyPairRequest);

}
