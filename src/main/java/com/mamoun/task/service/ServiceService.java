package com.mamoun.task.service;

import com.mamoun.task.dao.CarDao;
import com.mamoun.task.dao.CustomerDao;
import com.mamoun.task.dao.ServiceDao;
import com.mamoun.task.dto.request.RecordServiceRq;
import com.mamoun.task.dto.response.FindAllCarRs;
import com.mamoun.task.dto.response.FindAllServiceRs;
import com.mamoun.task.entity.Car;
import com.mamoun.task.entity.Customer;
import com.mamoun.task.exception.HttpServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServiceService {

    @Autowired
    private ServiceDao serviceDao;

    @Autowired
    private CarDao carDao;

    public List<FindAllServiceRs> findAllServiceByCarChassisNumber(String chassisNumber){

        Car car = carDao.findCarByChassisNumber(chassisNumber);

        if(car == null){
            throw new HttpServiceException(HttpStatus.NOT_FOUND, "No car found");
        }

        List<com.mamoun.task.entity.Service> serviceList = serviceDao.findServiceByCar(car);

        if(serviceList == null || serviceList.isEmpty()){
            throw new HttpServiceException(HttpStatus.NOT_FOUND, "No service found");
        }

        List<FindAllServiceRs> findAllServiceRsList = new ArrayList<>();

        serviceList.forEach(service -> {
            findAllServiceRsList.add(service.convertToFindAllServiceRs());
        });

        return findAllServiceRsList;
    }


    public void saveNewService(RecordServiceRq recordServiceRq){

        Car car = carDao.findCarByChassisNumber(recordServiceRq.getChassisNumber());

        if(car == null){
            throw new HttpServiceException(HttpStatus.NOT_FOUND, "No car found");
        }

        com.mamoun.task.entity.Service service = new com.mamoun.task.entity.Service();
        service.setCar(car);
        service.setName(recordServiceRq.getName());
        service.setDescription(recordServiceRq.getDescription());
        service.setCreateDate(LocalDateTime.now());

        serviceDao.save(service);
    }
}
