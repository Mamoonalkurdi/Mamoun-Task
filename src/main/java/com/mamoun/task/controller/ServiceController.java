package com.mamoun.task.controller;

import com.mamoun.task.config.Response;
import com.mamoun.task.dto.request.RecordServiceRq;
import com.mamoun.task.dto.response.FindAllCarRs;
import com.mamoun.task.dto.response.FindAllServiceRs;
import com.mamoun.task.service.CarService;
import com.mamoun.task.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Response> findAllServiceByCar(@RequestParam(value = "chassisNumber", required = true) String chassisNumber){

        List<FindAllServiceRs> findAllServiceRs = serviceService.findAllServiceByCarChassisNumber(chassisNumber);

        Response response = new Response(HttpStatus.OK.value(), "Operation Done Successfully",findAllServiceRs);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Response> findAllCarByCustomer(@RequestBody RecordServiceRq recordServiceRq){

        recordServiceRq.validate();

        serviceService.saveNewService(recordServiceRq);

        Response response = new Response(HttpStatus.OK.value(), "Operation Done Successfully",null);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
