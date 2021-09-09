package com.mamoun.task.controller;

import com.mamoun.task.config.Response;
import com.mamoun.task.dto.response.FindAllCustomerRs;
import com.mamoun.task.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Response> findAllCustomer(){

        List<FindAllCustomerRs> findAllCustomerRsList = customerService.findAllCustomer();

        Response response = new Response(HttpStatus.OK.value(), "Operation Done Successfully",findAllCustomerRsList);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
