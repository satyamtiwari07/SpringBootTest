package com.example.realTemp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
public class DriverDto {
    @Id
    private UUID id;
    private String fname;
    private String lname;
    private Integer age;
    private String description;

    public DriverDto() {
    }

    public DriverDto(UUID id, String fname, String lname, Integer age, String description) {
        this.id=id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
