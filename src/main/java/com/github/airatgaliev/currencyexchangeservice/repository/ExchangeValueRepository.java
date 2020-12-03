package com.github.airatgaliev.currencyexchangeservice.repository;

import com.github.airatgaliev.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

  ExchangeValue findByFromAndTo(String from, String to);
}
