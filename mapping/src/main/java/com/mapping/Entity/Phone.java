package com.mapping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="phones")
public class Phone {
    @Id
    long phoneNo;
    String serviceProvider;

    @ManyToOne
    Drivers driver;


    public Phone() {
    }

    public Phone(long phoneNo, String serviceProvider) {
        this.phoneNo = phoneNo;
        this.serviceProvider = serviceProvider;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
}
