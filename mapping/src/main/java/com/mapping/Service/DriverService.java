package com.mapping.Service;


import com.mapping.Entity.Drivers;
import com.mapping.Entity.Vehicals;

import java.util.List;

public interface DriverService {

    List<Drivers> findAllDriver();
    Drivers putDriver(Drivers driver);

    void putDriver(Drivers driver , Vehicals vehical);

    void putDrivermanually();

    void putOneToManyManually();

    void putManyToManyManually();
}
