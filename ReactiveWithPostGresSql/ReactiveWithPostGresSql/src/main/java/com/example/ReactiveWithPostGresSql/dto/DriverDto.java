package com.example.ReactiveWithPostGresSql.dto;

import org.springframework.data.annotation.Id;



public class DriverDto {

    @Id

    private int id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String description;

    public DriverDto() {
    }

    public DriverDto(int id, String firstname, String lastname, Integer age, String description) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }




}
