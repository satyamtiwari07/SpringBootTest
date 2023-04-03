package com.example.PostGreSqldemo.service;

import com.example.PostGreSqldemo.Exception.AllException;
import com.example.PostGreSqldemo.dto.DriverDto;
import com.example.PostGreSqldemo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.PostGreSqldemo.domian.Driver;

import java.util.*;

@Service
public class DriverServiceImpl implements DriverService {


    DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @Override
    public void addDriver(DriverDto dto) {
        Driver d = new Driver();
        d.setAge(dto.getAge());
        d.setId(dto.getId());
        d.setDescription(dto.getDescription());
        d.setName(dto.getName());
        d.setSurname(dto.getSurname());
        driverRepository.save(d);

    }

    public Driver aDriver(DriverDto dto) {
        Driver d = new Driver();
        d.setAge(dto.getAge());
        d.setId(dto.getId());
        d.setDescription(dto.getDescription());
        d.setName(dto.getName());
        d.setSurname(dto.getSurname());
        return driverRepository.save(d);

    }

    @Override
    public List<DriverDto> getAllDriver(){
        List<Driver> DriverList = driverRepository.findAll();
        List<DriverDto> templist = new ArrayList<>();

        for (Driver d : DriverList) {
            DriverDto driverdto = new DriverDto(d);
            templist.add(driverdto);
        }
        return templist;
    }

    @Override
    public void DeleteAll(){
        driverRepository.deleteAll();
    }

    @Override
    public DriverDto putMethod(DriverDto dto , UUID id) throws AllException {
        Optional<Driver> temp = driverRepository.findById(id);
       if(temp.isEmpty()) {
           throw new AllException("Cannot Find the user");
//           return ResponseEntity.notFound().build();
       }
        dto.setId(id);
        return new DriverDto(aDriver(dto));
    }

    @Override
    public void deleteById(UUID id) {
        driverRepository.deleteById(id);
    }

    @Override
    public void dispatchDriver(DriverDto driver, UUID id) throws AllException {
        Optional<Driver> temp = driverRepository.findById(id);
        if(temp.isEmpty())
            throw new AllException("Cannot Find the user");
        driver.setId(id);
        addDriver(driver);
    }


}
