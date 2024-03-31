package com.example.exchange.communication.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalExchangeRateData {

    @JsonProperty("code")
    private String code;

    @JsonProperty("codein")
    private String codeIn;

    @JsonProperty("name")
    private String name;

    @JsonProperty("high")
    private BigDecimal high;

    @JsonProperty("low")
    private BigDecimal low;

    @JsonProperty("varBid")
    private BigDecimal varBid;

    @JsonProperty("pctChange")
    private BigDecimal pctChange;

    @JsonProperty("bid")
    private BigDecimal bid;

    @JsonProperty("ask")
    private BigDecimal ask;

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("create_date")
    private String createDate;
}
