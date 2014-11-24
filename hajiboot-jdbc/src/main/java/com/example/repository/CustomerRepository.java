package com.example.repository;

import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shimizukazuki on 2014/11/24.
 */
@Repository
public class CustomerRepository {

    NamedParameterJdbcOperations jdbcOperations;
    SimpleJdbcInsertOperations jdbcInsertOperations;

    @Autowired
    public CustomerRepository(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.jdbcInsertOperations = new SimpleJdbcInsert((JdbcTemplate) jdbcOperations.getJdbcOperations())
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");

    }

    private static final RowMapper<Customer> customerRowMapper = (rs, i) -> {
        return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
    };

    public List<Customer> findAll() {
        return jdbcOperations.query("SELECT id,first_name,last_name FROM customers ORDER BY id", customerRowMapper);
    }

    public Customer findOne(Integer id) {
        return jdbcOperations.queryForObject("SELECT id, first_name, last_name WHERE id = :id", new MapSqlParameterSource().addValue("id", id), customerRowMapper);
    }

    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            Number id = jdbcInsertOperations.executeAndReturnKey(new BeanPropertySqlParameterSource(customer));
            customer.setId(id.intValue());
        } else {
            jdbcOperations.update("UPDATE customers SET first_name = :firstName ,last_name = :lastName WHERE id = :id", new BeanPropertySqlParameterSource(customer));
        }
        return customer;
    }

    public void delete(Integer id) {
        jdbcOperations.update("DELETE FROM customers WHERE id = :id", new MapSqlParameterSource().addValue("id", id));
    }

}
