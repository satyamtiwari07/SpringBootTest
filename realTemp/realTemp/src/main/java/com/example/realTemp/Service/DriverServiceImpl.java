package com.example.realTemp.Service;

import com.example.realTemp.DAO.DriverDao;
import com.example.realTemp.Entity.Drivers;
import com.example.realTemp.Exception.DriverNotFoundException;
import com.example.realTemp.Repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    DriverDao driverDao;
    DriverRepository dr;
    @Autowired
    public void DriverServiceImpl(DriverDao driverDao){
        this.driverDao = driverDao;
    }

    @Autowired
    public DriverServiceImpl(DriverRepository dr) {
        this.dr = dr;
    }

    @Override
    public List<Drivers> findAllDriver() {
        return driverDao.findAllDriver();
    }

    @Override
    @Transactional
    public Drivers putDriver(Drivers driver) {
        return driverDao.putDriver(driver);
    }

    @Override
    public Drivers updateDriver(Drivers driver, int id) {

        if(id<0 || id>findAllDriver().size())
            throw new DriverNotFoundException("Driver with this " + id +" is not Available");

        Drivers d = new Drivers();
        Optional<Drivers> s = dr.findById(id);

        d=s.get();
        d.setfName(driver.getfName());
        d.setlName(driver.getlName());
        return dr.save(d);
    }
}
