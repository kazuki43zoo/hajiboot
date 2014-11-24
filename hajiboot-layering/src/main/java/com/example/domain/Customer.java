package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by shimizukazuki on 2014/11/24.
 */
@Data
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
}
