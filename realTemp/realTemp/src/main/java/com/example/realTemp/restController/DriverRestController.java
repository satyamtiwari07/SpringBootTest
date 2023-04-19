package com.example.realTemp.restController;

import com.example.realTemp.entity.Drivers;
import com.example.realTemp.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class DriverRestController {

    DriverService driverService;

    @Autowired
    public void DriverRestController(DriverService driverService){
        this.driverService = driverService;
    }
    @GetMapping("/drivers")
    List<Drivers> findAllDriver(){
        return driverService.findAllDriver();
    }

    @PostMapping()
    Drivers putDriver(@Valid @RequestBody Drivers driver) {
        return driverService.putDriver(driver);
    }

    @PutMapping("/driver/{id}")
    Drivers updateDriver(@PathVariable(value = "id") UUID id, @RequestBody Drivers driver) {
        return driverService.updateDriver(driver,id);
    }

    @DeleteMapping("/driver/{id}")
    Drivers deleteDriver(@PathVariable(value="id") UUID id){
        return driverService.deleteDriverById(id);
    }

    @GetMapping("/driver/{id}")
    Drivers findDriverById(@PathVariable (value="id") UUID id){
        return driverService.findDriverById(id);
    }


}
