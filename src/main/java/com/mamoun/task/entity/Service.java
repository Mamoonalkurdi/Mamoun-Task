package com.mamoun.task.entity;

import com.mamoun.task.dto.response.FindAllCustomerRs;
import com.mamoun.task.dto.response.FindAllServiceRs;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "service")
public
class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serv_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "serv_name", nullable = false, length = 40)
    private String name;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "serv_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public FindAllServiceRs convertToFindAllServiceRs(){

        FindAllServiceRs findAllServiceRs = new FindAllServiceRs();
        findAllServiceRs.setId(this.id);
        findAllServiceRs.setName(this.name);
        findAllServiceRs.setDescription(this.description);
        findAllServiceRs.setCarId(this.car.getId());
        findAllServiceRs.setCreateDate(this.createDate);

        return findAllServiceRs;
    }
}
