package com.example.app;

import org.springframework.stereotype.Component;

/**
 * Created by shimizukazuki on 2014/11/24.
 */
@Component
public class AddCalculator implements  Calculator{
    public int calc(int a, int b){
        return a + b;
    }
}
