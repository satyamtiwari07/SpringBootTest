package com.reactive.reactive.services;

import com.reactive.reactive.dto.DriverDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DriverService {
    Mono<DriverDto> saveDriver(DriverDto driverDto);

    Mono<DriverDto> getDriver(String driverID);

    Flux<DriverDto> getAllDriver();

    Mono<DriverDto> updateDriver(DriverDto driverDto , String driverId);

    Mono<Void>deleteDriver(String driverId);

}
