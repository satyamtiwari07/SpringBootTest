package com.example.AOPDemo.Entity;

public class Drivers {
    private String driverId;
    private String firstName;
    private String secondName;

    public Drivers() {

    }

    public Drivers(String driverId, String firstName, String secondName) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
