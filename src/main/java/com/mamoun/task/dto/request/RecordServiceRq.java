package com.mamoun.task.dto.request;

import com.mamoun.task.exception.HttpServiceException;
import org.springframework.http.HttpStatus;

public class RecordServiceRq {


    private String name;
    private String description;
    private String chassisNumber;

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

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public void validate(){

        if(name == null || name.isEmpty()){
            throw new HttpServiceException(HttpStatus.BAD_REQUEST,"name is required");
        }

        if(chassisNumber == null || chassisNumber.isEmpty()){
            throw new HttpServiceException(HttpStatus.BAD_REQUEST,"chassis number is required");
        }

    }
}
