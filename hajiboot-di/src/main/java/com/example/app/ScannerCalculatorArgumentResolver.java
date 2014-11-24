package com.example.app;

import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by shimizukazuki on 2014/11/24.
 */
@Component
public class ScannerCalculatorArgumentResolver implements CalculatorArgumentResolver {

    @Override
    public CalculatorArgument resolve() {
        CalculatorArgument argument = null;
        try(Scanner scanner = new Scanner(System.in)){
            argument = new CalculatorArgument(scanner.nextInt(),scanner.nextInt());
        }
        return argument;
    }
}
