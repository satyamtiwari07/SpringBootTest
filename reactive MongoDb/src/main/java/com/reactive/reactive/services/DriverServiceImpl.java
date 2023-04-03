package com.reactive.reactive.services;

import com.reactive.reactive.dto.DriverDto;
import com.reactive.reactive.entity.Driver;
import com.reactive.reactive.mapper.DriverMapper;
import com.reactive.reactive.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService{

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Mono<DriverDto> saveDriver(DriverDto driverDto){

        Driver driver = DriverMapper.mapToDriver(driverDto);
        Mono<Driver> savedDriver = driverRepository.save(driver);
        return savedDriver.map(DriverEntity->DriverMapper.mapToDriverDto(driver));
    }

    @Override
    public Mono<DriverDto> getDriver(String driverID) {
        Mono<Driver> driverMono = driverRepository.findById(driverID);
        return driverMono.map(driver->DriverMapper.mapToDriverDto(driver));
    }


    @Override
    public Flux<DriverDto> getAllDriver() {
        Flux<Driver> DriverFlux = driverRepository.findAll();
        return DriverFlux
                .map((driver)->DriverMapper.mapToDriverDto(driver))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<DriverDto> updateDriver(DriverDto driverDto, String driverId) {

        Mono<Driver> driverUpdate = driverRepository.findById(driverId);


        return driverUpdate
                .flatMap((existingDriver)->{
                    existingDriver.setId(driverDto.getId());
                    existingDriver.setFirstname(driverDto.getFirstname());
                    existingDriver.setLastname(driverDto.getLastname());
                    existingDriver.setAge(driverDto.getAge());
                    existingDriver.setDesc(driverDto.getDesc());
                    return driverRepository.save(existingDriver);
        }).map((driver)->DriverMapper.mapToDriverDto(driver));
    }

    @Override
    public Mono<Void> deleteDriver(String driverId) {
        return driverRepository.deleteById(driverId);
    }
}
