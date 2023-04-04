package com.example.ReactiveWithPostGresSql.controller;


import com.example.ReactiveWithPostGresSql.dto.DriverDto;
import com.example.ReactiveWithPostGresSql.services.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/driver")
public class driverController {

    @Autowired
    DriverServiceImpl driverService;

    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<DriverDto> saveDriver(@RequestBody DriverDto driverDto){
        return  driverService.saveDriver(driverDto);
    }

    @GetMapping("{id}")
    public Mono<DriverDto> getDriver(@PathVariable("id") Integer driverId){
        return driverService.getDriver(driverId);
    }

    @GetMapping
    public Flux<DriverDto> getAllDriver() {
        return driverService.getAllDriver();
    }

    @PutMapping("{id}")
    public Mono<DriverDto> updateDriver(@RequestBody DriverDto driverDto,
                                         @PathVariable("id") Integer driverId){

        return driverService.updateDriver(driverDto,driverId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteDriver(@PathVariable("id") Integer driverID){
        return driverService.deleteDriver(driverID);
    }

}
