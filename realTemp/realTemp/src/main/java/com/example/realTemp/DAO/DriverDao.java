package com.example.realTemp.DAO;

import com.example.realTemp.Entity.Drivers;

import java.util.List;

public interface DriverDao {
    List<Drivers> findAllDriver();
    Drivers putDriver(Drivers driver);
}
