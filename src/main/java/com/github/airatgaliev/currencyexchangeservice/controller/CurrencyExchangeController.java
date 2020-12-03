package com.github.airatgaliev.currencyexchangeservice.controller;

import com.github.airatgaliev.currencyexchangeservice.model.ExchangeValue;
import com.github.airatgaliev.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Value("${server.port}")
  private int port;
  @Autowired
  private ExchangeValueRepository exchangeValueRepository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
    exchangeValue.setPort(port);
    return exchangeValue;
  }
}
