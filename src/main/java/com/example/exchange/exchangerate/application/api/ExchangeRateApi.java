package com.example.exchange.exchangerate.application.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/rate")
public interface ExchangeRateApi {

    @PostMapping(value = "/{idPair}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ExchangeRateResponse postRate(@RequestBody ExchangeRateRequest exchangeRateRequest,
                                  @PathVariable UUID idPair);
}
