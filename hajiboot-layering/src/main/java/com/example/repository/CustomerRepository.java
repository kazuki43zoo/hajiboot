package com.example.repository;

import com.example.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by shimizukazuki on 2014/11/24.
 */
@Repository
public class CustomerRepository {


    private final ConcurrentMap<Integer,Customer> customers = new ConcurrentHashMap<>();

    public List<Customer> findAll(){
        return new ArrayList<>(customers.values());
    }

    public Customer findOne(Integer id){
        return customers.get(id);
    }

    public Customer save(Customer customer){
        return customers.put(customer.getId(),customer);
    }

    public void delete(Integer id){
        customers.remove(id);
    }

}
