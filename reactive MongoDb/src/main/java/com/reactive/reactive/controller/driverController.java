package com.reactive.reactive.controller;

import com.reactive.reactive.dto.DriverDto;
import com.reactive.reactive.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/driver")
public class driverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<DriverDto> saveDriver(@RequestBody DriverDto driverDto){
        return  driverService.saveDriver(driverDto);
    }

    @GetMapping("{id}")
    public Mono<DriverDto> getDriver(@PathVariable("id") String driverId){
        return driverService.getDriver(driverId);
    }

    @GetMapping
    public Flux<DriverDto> getAllDriver() {
        return driverService.getAllDriver();
    }

    @PutMapping("{id}")
    public Mono<DriverDto> updateDriver(@RequestBody DriverDto driverDto,
                                         @PathVariable("id") String driverId){

        return driverService.updateDriver(driverDto,driverId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteDriver(@PathVariable("id") String driverID){
        return driverService.deleteDriver(driverID);
    }

}
