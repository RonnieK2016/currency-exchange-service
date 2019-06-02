package com.udemy.microservices.currencyexchangeservice.controllers;

import com.udemy.microservices.currencyexchangeservice.domain.ExchangeValue;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        return ExchangeValue.builder().id(1L)
                .from(from)
                .to(to)
                .conversionMultiple(BigDecimal.valueOf(65L))
                .port(Integer.parseInt(environment.getProperty("local.server.port")))
                .build();
    }
}
