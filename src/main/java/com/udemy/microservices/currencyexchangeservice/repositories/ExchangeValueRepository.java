package com.udemy.microservices.currencyexchangeservice.repositories;

import com.udemy.microservices.currencyexchangeservice.domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
