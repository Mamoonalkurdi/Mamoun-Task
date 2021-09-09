package com.mamoun.task.controller;

import com.mamoun.task.config.Response;
import com.mamoun.task.dto.response.FindAllCarRs;
import com.mamoun.task.dto.response.FindAllCustomerRs;
import com.mamoun.task.service.CarService;
import com.mamoun.task.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Response> findAllCarByCustomer(@RequestParam(value = "customerId", required = true) Long customerId){

        List<FindAllCarRs> findAllCarRsList = carService.findAllCarByCustomerId(customerId);

        Response response = new Response(HttpStatus.OK.value(), "Operation Done Successfully",findAllCarRsList);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
