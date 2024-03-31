package com.example.exchange.communication.service;


import com.example.exchange.communication.api.ExchangeRates;
import com.example.exchange.communication.api.ExternalExchangeRateData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

@Service
@Log4j2
public class ExternalExchangeRateService {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Optional< ExternalExchangeRateData> fetchExternalExchangeRate(String baseCurrency, String targetCurrency) {
        String currencyPairKey = baseCurrency + "-" + targetCurrency;
        String url = "https://economia.awesomeapi.com.br/last/" + currencyPairKey;
        log.info("Fetching exchange rate from URL: {}", url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            log.info("Response body: {}", responseBody);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(responseBody);
            JsonNode ratesNode = rootNode.path("USDEUR");

            if(ratesNode.isMissingNode()){
                log.error("Taxa não encontrada para o par: {}", currencyPairKey);
                throw new RuntimeException("Não foi possível buscar a taxa de câmbio.");
            }

            ExternalExchangeRateData rateData = mapper.treeToValue(ratesNode, ExternalExchangeRateData.class);
            return Optional.ofNullable(rateData);

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); // ou maneje o erro de maneira mais apropriada para sua aplicação
        }
    }

}