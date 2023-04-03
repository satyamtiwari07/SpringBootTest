package com.example.realTemp.Service;



import com.example.realTemp.Entity.Drivers;

import java.util.List;

public interface DriverService {

    List<Drivers> findAllDriver();
    Drivers putDriver(Drivers driver);

    Drivers updateDriver(Drivers driver,int id);
}
