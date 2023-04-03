package com.example.realTemp.RestController;

import com.example.realTemp.Entity.Drivers;
import com.example.realTemp.Exception.DriverNotFoundException;
import com.example.realTemp.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    Drivers putDriver(@RequestBody Drivers driver)
    {
        return driverService.putDriver(driver);
    }

    @PutMapping("/drivers/{id}")
    Drivers updateDriver(@PathVariable(value = "id") int id,@RequestBody Drivers driver)
    {
        return driverService.updateDriver(driver,id);
    }




}
