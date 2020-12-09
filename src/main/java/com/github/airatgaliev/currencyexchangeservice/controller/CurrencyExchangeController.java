package com.github.airatgaliev.currencyexchangeservice.controller;

import com.github.airatgaliev.currencyexchangeservice.model.ExchangeValue;
import com.github.airatgaliev.currencyexchangeservice.repository.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Value("${server.port}")
  private int port;
  @Autowired
  private ExchangeValueRepository exchangeValueRepository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
    exchangeValue.setPort(port);
    logger.info("{}", exchangeValue);
    return exchangeValue;
  }
}
