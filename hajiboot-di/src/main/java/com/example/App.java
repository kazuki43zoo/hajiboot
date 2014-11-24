package com.example;

import com.example.app.Calculator;
import com.example.app.CalculatorArgument;
import com.example.app.CalculatorArgumentResolver;
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

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
        }
    }

    @Autowired
    CalculatorArgumentResolver calculatorArgumentResolver;

    @Autowired
    Calculator calculator;

    public void run(String... args) {
        System.out.println("Enter 2 numbers like 'a b' : ");
        CalculatorArgument argument = calculatorArgumentResolver.resolve();
        int result = calculator.calc(argument.getA(), argument.getB());
        System.out.println("result = " + result);
    }

}
