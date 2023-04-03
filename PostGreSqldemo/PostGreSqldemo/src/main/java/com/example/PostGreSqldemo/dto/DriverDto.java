package com.example.PostGreSqldemo.dto;
import com.example.PostGreSqldemo.domian.Driver;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
public class DriverDto {

    @NotNull(message = "Id cannot be Null")
    private UUID id;

    @NotNull(message = "Name cannot be Null")
    private String name;

    private String surname;
    @NegativeOrZero(message = "Age cannot be zero or negative")
    private int age;

    private String description;
    public DriverDto(){

    }

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.surname = driver.getSurname();
        this.age = driver.getAge();
        this.description = driver.getDescription();
    }

}
