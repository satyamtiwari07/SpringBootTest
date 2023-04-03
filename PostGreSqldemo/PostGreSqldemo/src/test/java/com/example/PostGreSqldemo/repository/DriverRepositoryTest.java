package com.example.PostGreSqldemo.repository;

import com.example.PostGreSqldemo.domian.Driver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DriverRepositoryTest {

    @Autowired
    DriverRepository driverRepository;

    @Test
    void TestDriverRepository(){

        //Arrange
        Driver driver = Driver.builder().
                name("Vikas")
                .age(33)
                .surname("Jayanti")
                .description("DevOps Engineer")
                .build();


        //Act
        Driver saveDriver = driverRepository.save(driver);


        //Assert
        Assertions.assertNotNull(saveDriver);
        Assertions.assertTrue(saveDriver.getAge()>0);

    }

    @Test
    void TestDriverRepository_GetMethod(){
        //Arrange
        Driver driver1 = Driver.builder().
                name("Vikas")
                .age(33)
                .surname("Jayanti")
                .description("DevOps Engineer")
                .build();

        Driver driver2 = Driver.builder().
                name("Satyam")
                .age(23)
                .surname("Tiwari")
                .description("Full stack developer")
                .build();

        //Act
       driverRepository.save(driver1);
       driverRepository.save(driver2);

       List<Driver> ListDriver = driverRepository.findAll();

       Assertions.assertNotNull(ListDriver);
       Assertions.assertTrue(ListDriver.size()==2);

    }

    @Test
    void TestDriverRepository_FindByIdMethod(){
        //Arrange
        Driver driver1 = Driver.builder()
                .name("Vikas")
                .age(33)
                .surname("Jayanti")
                .description("DevOps Engineer")
                .build();

        //Act
        driverRepository.save(driver1);

        Driver driverList = driverRepository.findById(driver1.getId()).get();

        Assertions.assertNotNull(driverList);

    }

    @Test
    void TestDriverRepository_DeleteMethod(){
        //Arrange
        Driver driver1 = Driver.builder()
//                .id(a9b4dae9-268f-4236-b9cd-570331a4a303)
                .name("Vikas")
                .age(33)
                .surname("Jayanti")
                .description("DevOps Engineer")
                .build();

        //Act
        driverRepository.save(driver1);
//        System.out.println(driver1.getId());

        driverRepository.deleteById(driver1.getId());

        Optional<Driver> driverList = driverRepository.findById(driver1.getId());

        System.out.println(driverList);

        Assertions.assertTrue(driverList.isEmpty());

    }

    @Test
    void TestDriverRepository_UpdateMethod()
    {
        //Arrange
        Driver driver1 = Driver.builder()
                .name("Vikas")
                .age(33)
                .surname("Jayanti")
                .description("DevOps Engineer")
                .build();

        //Act
        driverRepository.save(driver1);

        Driver d=driverRepository.findById(driver1.getId()).get();

        Assertions.assertNotNull(d);

        d.setName("satyam");
        Assertions.assertNotNull(d);

    }

}