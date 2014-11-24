package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shimizukazuki on 2014/11/24.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
