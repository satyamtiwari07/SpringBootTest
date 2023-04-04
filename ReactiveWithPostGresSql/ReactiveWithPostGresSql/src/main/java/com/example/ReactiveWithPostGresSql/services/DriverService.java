package com.example.ReactiveWithPostGresSql.services;


import com.example.ReactiveWithPostGresSql.dto.DriverDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DriverService {
    Mono<DriverDto> saveDriver(DriverDto driverDto);

    Mono<DriverDto> getDriver(Integer driverID);

    Flux<DriverDto> getAllDriver();

    Mono<DriverDto> updateDriver(DriverDto driverDto , Integer driverId);

    Mono<Void>deleteDriver(Integer driverId);

}
