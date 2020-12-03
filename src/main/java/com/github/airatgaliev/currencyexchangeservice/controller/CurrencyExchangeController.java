package com.github.airatgaliev.currencyexchangeservice.controller;

import com.github.airatgaliev.currencyexchangeservice.model.ExchangeValue;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Value("${server.port}")
  private int port;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(75));
    exchangeValue.setPort(port);
    return exchangeValue;
  }
}
