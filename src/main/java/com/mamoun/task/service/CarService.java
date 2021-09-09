package com.mamoun.task.service;

import com.mamoun.task.dao.CarDao;
import com.mamoun.task.dao.CustomerDao;
import com.mamoun.task.dto.response.FindAllCarRs;
import com.mamoun.task.dto.response.FindAllCustomerRs;
import com.mamoun.task.entity.Car;
import com.mamoun.task.entity.Customer;
import com.mamoun.task.exception.HttpServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CarDao carDao;

    public List<FindAllCarRs> findAllCarByCustomerId(Long customerId){

        Customer customer = customerDao.findCustomerById(customerId);

        if(customer == null){
            throw new HttpServiceException(HttpStatus.NOT_FOUND, "No customer found");
        }

        List<Car> carList = carDao.findCarByCustomer(customer);

        if(carList == null || carList.isEmpty()){
            throw new HttpServiceException(HttpStatus.NOT_FOUND, "No car found");
        }

        List<FindAllCarRs> findAllCarRsList = new ArrayList<>();

        carList.forEach(car -> {
            findAllCarRsList.add(car.convertToFindAllCustomerRsDto());
        });

        return findAllCarRsList;
    }
}
