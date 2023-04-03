package com.mapping.Controller;

import com.mapping.Entity.Drivers;
import com.mapping.Entity.Vehicals;
import com.mapping.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    DriverService driverService;

    @Autowired
    public void Controller(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping("/details")
    List<Drivers> getAllDrivers(){
        return driverService.findAllDriver();
    }

    @RequestMapping("/putDriver")
    Drivers putAllDriver(@RequestBody Drivers drivers){
        return driverService.putDriver(drivers);
    }

    @RequestMapping("/putDriverAndVehical")
    void putDriverAndVehical(@RequestBody Drivers drivers ,@RequestBody Vehicals vehicals){
        driverService.putDriver(drivers, vehicals);
    }

    @RequestMapping("/putDriverAndVehicalmanually")
    void putDriverAndVehicalmanually(){
        driverService.putDrivermanually();
    }

    @RequestMapping("/oneToManyManually")
    void putOneToManyManually(){
        driverService.putOneToManyManually();
    }

    @RequestMapping("/manyToManyManually")
    void putManyToManyManually(){
        driverService.putManyToManyManually();
    }




}
