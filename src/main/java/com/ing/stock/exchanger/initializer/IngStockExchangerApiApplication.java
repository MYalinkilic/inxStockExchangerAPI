package com.ing.stock.exchanger.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ing.stock.exchanger")
@EnableJpaRepositories(basePackages = "com.ing.stock.exchanger.db.repos")
@EntityScan(basePackages = "com.ing.stock.exchanger.db")
@ComponentScan(basePackages = "com.ing.stock.exchanger")
public class IngStockExchangerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngStockExchangerApiApplication.class, args);
    }

}
