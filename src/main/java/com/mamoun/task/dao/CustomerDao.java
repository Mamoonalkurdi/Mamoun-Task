package com.mamoun.task.dao;

import com.mamoun.task.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerDao extends CrudRepository<Customer, Long> {

    public List<Customer> findAll();

    public Customer findCustomerById(Long customerId);
}
