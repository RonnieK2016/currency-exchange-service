package com.udemy.microservices.currencyexchangeservice.bootstrap;

import com.udemy.microservices.currencyexchangeservice.domain.ExchangeValue;
import com.udemy.microservices.currencyexchangeservice.repositories.ExchangeValueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private ExchangeValueRepository exchangeValueRepository;

    public DataLoader(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(exchangeValueRepository.count() == 0) {
            insertExchangeValueData();
        }
    }

    private void insertExchangeValueData() {
        ExchangeValue usdToInr = ExchangeValue.builder()
                .from("USD").to("INR").conversionMultiple(BigDecimal.valueOf(65L)).build();

        ExchangeValue eurToInr = ExchangeValue.builder()
                .from("EUR").to("INR").conversionMultiple(BigDecimal.valueOf(75L)).build();

        ExchangeValue audToInr = ExchangeValue.builder()
                .from("AUD").to("INR").conversionMultiple(BigDecimal.valueOf(25L)).build();

        exchangeValueRepository.save(usdToInr);
        exchangeValueRepository.save(eurToInr);
        exchangeValueRepository.save(audToInr);

        System.out.println("Inserted " + exchangeValueRepository.count() + " values ");
    }


}
