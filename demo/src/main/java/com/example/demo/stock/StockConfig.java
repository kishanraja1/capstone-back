package com.example.demo.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StockConfig {

    @Bean
    CommandLineRunner commandLineRunner(StockRepository repository){
        return args -> {
            Stock ford = new Stock(
                    "Ford",
                    "F",
                    16.83,
                    "sell - dying company"
            );

            Stock netflix = new Stock(
                    "Netflix",
                    "NFLX",
                    375.71,
                    "buy - making alot of money"
            );

            repository.saveAll(
                    List.of(ford, netflix)
            );
        };
    }
}
