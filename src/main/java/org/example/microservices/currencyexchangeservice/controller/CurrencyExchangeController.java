package org.example.microservices.currencyexchangeservice.controller;

import org.example.microservices.currencyexchangeservice.dao.CurrencyRepo;
import org.example.microservices.currencyexchangeservice.dto.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private Environment environment;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        String port = environment.getProperty("local.server.port");
//        currencyRepo.currencyRepo
        CurrencyExchange currencyExchange = currencyRepo.findByFromAndTo(from, to);
        if(currencyExchange == null){
            throw new RuntimeException("Unable to find data from " + from + " to " + to);
        }
        return currencyExchange;
    }
}
