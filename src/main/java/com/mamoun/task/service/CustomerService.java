package com.mamoun.task.service;

import com.mamoun.task.dao.CustomerDao;
import com.mamoun.task.dto.response.FindAllCustomerRs;
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
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<FindAllCustomerRs> findAllCustomer(){

        List<Customer> customerList = customerDao.findAll();

        if(customerList == null || customerList.isEmpty()){
            throw new HttpServiceException(HttpStatus.NOT_FOUND, "No customer found");
        }

        List<FindAllCustomerRs> findAllCustomerRsList = new ArrayList<>();

        customerList.forEach(customer -> {
            findAllCustomerRsList.add(customer.convertToFindAllCustomerRsDto());
        });

        return findAllCustomerRsList;
    }
}
