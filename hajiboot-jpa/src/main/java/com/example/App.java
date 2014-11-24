package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

/**
 * Hello world!
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        Customer customer = customerRepository.save(new Customer(null,"hoge","fuga"));

        System.out.println(customer);

        List<Customer> customers = customerRepository.findAll();

        customers.forEach(System.out::println);


    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
        }
    }


}
