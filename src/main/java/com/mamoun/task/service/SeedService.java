package com.mamoun.task.service;

import com.mamoun.task.dao.CarDao;
import com.mamoun.task.dao.CustomerDao;
import com.mamoun.task.dto.response.FindAllCarRs;
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
public class SeedService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CarDao carDao;

    public void seedData(){

        Customer mamoun = new Customer();
        mamoun.setFullName("Mamoun Essmat Alkurdi");
        mamoun.setMobileNumber("0796869833");

        customerDao.save(mamoun);

        Customer saif = new Customer();
        saif.setFullName("saif Esmaat Alkurdi");
        saif.setMobileNumber("0796869833");

        customerDao.save(saif);

        Customer ahmad = new Customer();
        ahmad.setFullName("Ahmad Esmaat Alkurdi");
        ahmad.setMobileNumber("0796869833");

        customerDao.save(ahmad);

        Car kia = new Car();
        kia.setName("KIA Rio");
        kia.setCustomer(mamoun);
        kia.setChassisNumber("00010001");
        kia.setManufacturingYear(2011);

        carDao.save(kia);

        Car lexuis = new Car();
        lexuis.setName("lexuis CT");
        lexuis.setCustomer(saif);
        lexuis.setChassisNumber("00010002");
        lexuis.setManufacturingYear(2012);

        carDao.save(lexuis);

        Car lancer = new Car();
        lancer.setName("Mitsubishi Lancer");
        lancer.setCustomer(ahmad);
        lancer.setChassisNumber("00010003");
        lancer.setManufacturingYear(2016);

        carDao.save(lancer);
    }
}
