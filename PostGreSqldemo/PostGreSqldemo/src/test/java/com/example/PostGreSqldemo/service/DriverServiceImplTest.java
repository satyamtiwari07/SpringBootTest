package com.example.PostGreSqldemo.service;

import com.example.PostGreSqldemo.Exception.AllException;
import com.example.PostGreSqldemo.domian.Driver;
import com.example.PostGreSqldemo.dto.DriverDto;
import com.example.PostGreSqldemo.repository.DriverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DataJpaTest
class DriverServiceImplTest {

    @InjectMocks
    DriverServiceImpl driverservice;

    @Mock
    DriverRepository dr;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void AddDriverTesting(){
        Driver d=new Driver(null,"Satyam","Tiwari",23,"ReactDeveloper");
        DriverDto driver =new DriverDto(d);

        when(dr.save(any())).thenReturn(d);
        driverservice.addDriver(driver);
        Assertions.assertEquals(d.getId(),driver.getId());
    }

    @Test
    public void getAllDriverTesting() {

        Driver d1 = new Driver();
        Driver d2 = new Driver();

        d1.setName("Satyam");
        d1.setSurname("Tiwari");
        d1.setDescription("Temporary");
        d1.setAge(23);

        d2.setName("Prateek");
        d2.setSurname("Shankar");
        d2.setDescription("Temporary2");
        d2.setAge(23);

        List<Driver> dlist = new ArrayList<>();
        dlist.add(d1);
        dlist.add(d2);

        Mockito.when(dr.findAll()).thenReturn(dlist);

        assertEquals(driverservice.getAllDriver().size(),dlist.size());
        assertEquals(driverservice.getAllDriver().get(0).getName(),dlist.get(0).getName());
        assertEquals(driverservice.getAllDriver().get(1).getName(),dlist.get(1).getName());
    }

    @Test
    void deleteAllTesting(){
        AddDriverTesting();
        doNothing().when(dr).deleteAll();
        driverservice.DeleteAll();
        assertEquals(driverservice.getAllDriver().size(),0);

    }

    @Test
    void deleteByIdTesting(){
        UUID id=UUID.randomUUID();
        Driver d=new Driver(id,"satyam","Tiwari",23,"react developer");
        DriverDto driver =new DriverDto(d);
        when(dr.save(any())).thenReturn(d);
        driverservice.addDriver(driver);


        doNothing().when(dr).deleteById(id);
        driverservice.deleteById(id);
        assertEquals(driverservice.getAllDriver().size(),0);
    }

    @Test
    void testingPutMethod() throws AllException {

        UUID id=UUID.randomUUID();

        Driver d = new Driver(id,"Satyam","Tiwari",23,"ReactDeveloper");
        DriverDto driver1 =new DriverDto(d);

        Driver d1 = new Driver(id,"Satyam1","Tiwari",23,"updated");
        DriverDto driver2 = new DriverDto(d1);
        when(dr.findById(id)).thenReturn(Optional.of(d));
        when(dr.save(any(Driver.class))).thenReturn(d1);

        Assertions.assertEquals(driverservice.putMethod(driver1,id).getName() , d1.getName() );


    }

}