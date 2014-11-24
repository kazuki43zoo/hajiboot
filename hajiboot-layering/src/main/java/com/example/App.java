package com.example;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {

    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
        }
    }

    @Override
    public void run(String... args) throws Exception {
        customerService.save(new Customer(1, "first1", "last1"));
        customerService.save(new Customer(2, "first2", "last2"));
        customerService.save(new Customer(3, "first3", "last3"));

        customerService.findAll().forEach(System.out::println);

    }
}
