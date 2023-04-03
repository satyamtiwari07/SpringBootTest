package com.example.AOPDemo.Service;

import com.example.AOPDemo.Entity.Drivers;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    public Drivers createEmployee( String DriverId, String fname, String sname)
    {
        Drivers d = new Drivers();
        d.setDriverId(DriverId);
        d.setFirstName(fname);
        d.setSecondName(sname);
        return d;
    }

    public void deleteEmployee(String empId)
    {
    }

}
