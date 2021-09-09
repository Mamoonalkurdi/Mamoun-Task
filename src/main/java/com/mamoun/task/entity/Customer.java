package com.mamoun.task.entity;

import com.mamoun.task.dto.response.FindAllCustomerRs;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "cus_full_name", nullable = false, length = 40)
    private String fullName;

    @Column(name = "cus_mobile_number", nullable = false, length = 14)
    private String mobileNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public FindAllCustomerRs convertToFindAllCustomerRsDto(){

        FindAllCustomerRs findAllCustomerRs = new FindAllCustomerRs();
        findAllCustomerRs.setId(this.id);
        findAllCustomerRs.setFullName(this.fullName);
        findAllCustomerRs.setMobileNumber(this.mobileNumber);

        return findAllCustomerRs;
    }
}
