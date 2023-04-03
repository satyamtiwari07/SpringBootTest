package com.example.PostGreSqldemo.controller;

import com.example.PostGreSqldemo.Exception.AllException;
import com.example.PostGreSqldemo.dto.DriverDto;
import com.example.PostGreSqldemo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DriverController {

    @Autowired
    DriverService ds;

    @GetMapping("/drivers")
    public List<DriverDto> getDriverName() {
        return ds.getAllDriver();
    }

    @RequestMapping(method = RequestMethod.POST , value="/driversname")
    public void addDriver(@RequestBody DriverDto driverdto){
        ds.addDriver(driverdto);
    }

    @RequestMapping(value="/despatchdriver/{id}", method= RequestMethod.PATCH)
    public void updateStatus(@RequestBody DriverDto driver, @PathVariable UUID id) throws AllException {
        ds.dispatchDriver(driver,id);
    }

    @RequestMapping(value = "/deleteall", method = RequestMethod.DELETE)
    public void deleteAll(){
        ds.DeleteAll();
    }

    @PutMapping("/driver/{id}")
    public DriverDto updateStudent(@RequestBody DriverDto d, @PathVariable UUID id) throws AllException {
        return ds.putMethod(d,id);
    }

    @DeleteMapping("/driver/{id}")
    public void deleteStudent(@PathVariable UUID id) {
         ds.deleteById(id);
    }

}
