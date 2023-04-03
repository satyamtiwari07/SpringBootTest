package com.reactive.reactive.mapper;

import com.reactive.reactive.dto.DriverDto;
import com.reactive.reactive.entity.Driver;

public class  DriverMapper {
    public static DriverDto mapToDriverDto(Driver driver){
        return new DriverDto(
                driver.getId(),
                driver.getFirstname(),
                driver.getLastname(),
                driver.getAge(),
                driver.getDesc()
        );
    }

    public static Driver mapToDriver(DriverDto driverDto){
        return new Driver(
                driverDto.getId(),
                driverDto.getFirstname(),
                driverDto.getLastname(),
                driverDto.getAge(),
                driverDto.getDesc()
        );
    }
}
