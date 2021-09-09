package com.mamoun.task.dao;

import com.mamoun.task.entity.Car;
import com.mamoun.task.entity.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceDao extends CrudRepository<Service, Long> {

    public List<Service> findServiceByCar(Car car);
}
