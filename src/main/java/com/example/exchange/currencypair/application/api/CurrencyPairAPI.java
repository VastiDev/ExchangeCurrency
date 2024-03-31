package com.example.exchange.currencypair.application.api;

import com.example.exchange.currencypair.domain.CurrencyPair;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/currencyPair")
public interface CurrencyPairAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CurrencyPairResponse postCurrencyPair (@Valid
                                           @RequestBody CurrencyPairRequest currencyPairRequest);

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    CurrencyPairDetailedResponse getPairById(@PathVariable UUID id);
}
