package com.mamoun.task.entity;

import com.mamoun.task.dto.response.FindAllCarRs;
import com.mamoun.task.dto.response.FindAllCustomerRs;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "chassis_number", nullable = false, unique = true, length = 14)
    private String chassisNumber;

    @Column(name = "car_name", nullable = false, length = 40)
    private String name;

    @Column(name = "car_manufact_year", nullable = false)
    private Integer manufacturingYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Integer manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FindAllCarRs convertToFindAllCustomerRsDto(){

        FindAllCarRs findAllCarRs = new FindAllCarRs();
        findAllCarRs.setId(this.id);
        findAllCarRs.setName(this.name);
        findAllCarRs.setChassisNumber(this.chassisNumber);
        findAllCarRs.setManufacturingYear(this.manufacturingYear);
        findAllCarRs.setCustomerId(this.customer.getId());

        return findAllCarRs;
    }
}
