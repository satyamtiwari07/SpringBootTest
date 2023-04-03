package com.example.PostGreSqldemo.service;

import com.example.PostGreSqldemo.Exception.AllException;
import com.example.PostGreSqldemo.dto.DriverDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    void addDriver(DriverDto d);

    List<DriverDto> getAllDriver();

    void DeleteAll();

    DriverDto putMethod(DriverDto d , UUID id) throws AllException;

    void deleteById(UUID id);

    void dispatchDriver(DriverDto driver, UUID id) throws AllException;
}
