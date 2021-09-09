package com.mamoun.task.dao;

import com.mamoun.task.entity.Car;
import com.mamoun.task.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarDao extends CrudRepository<Car, Long> {

    public List<Car> findCarByCustomer(Customer customer);

    public Car findCarByChassisNumber(String chassisNumber);
}
