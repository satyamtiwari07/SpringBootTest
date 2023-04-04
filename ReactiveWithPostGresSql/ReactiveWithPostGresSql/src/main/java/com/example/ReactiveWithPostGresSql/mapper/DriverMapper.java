package com.example.ReactiveWithPostGresSql.mapper;


import com.example.ReactiveWithPostGresSql.dto.DriverDto;
import com.example.ReactiveWithPostGresSql.entity.Driver;

public class  DriverMapper {
    public static DriverDto mapToDriverDto(Driver driver){
        return new DriverDto(
                driver.getId(),
                driver.getFirstname(),
                driver.getLastname(),
                driver.getAge(),
                driver.getdescription()
        );
    }

    public static Driver mapToDriver(DriverDto driverDto){
        return new Driver(
                driverDto.getId(),
                driverDto.getFirstname(),
                driverDto.getLastname(),
                driverDto.getAge(),
                driverDto.getdescription()
        );
    }
}
