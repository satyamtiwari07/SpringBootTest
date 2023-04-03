package com.mapping.Service;

import com.mapping.Entity.*;
import com.mapping.Repository.CategoryRepo;
import com.mapping.Repository.ProductRepo;
import com.mapping.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DriverServiceImpl implements DriverService{

   Repo r;

   @Autowired
   CategoryRepo cr;

   @Autowired
   ProductRepo pr;

    @Autowired
    public void DriverServiceImpl(Repo r){
        this.r = r;
    }

    @Override
    public List<Drivers> findAllDriver() {

        return r.findAll();
    }

    @Override
    public Drivers putDriver(Drivers driver) {
        return r.save(driver);
    }

    @Override
    public void putDriver(Drivers driver, Vehicals vehicals) {
        driver.setV(vehicals);
        r.save(driver);
    }

    @Override
    public void putDrivermanually() {
        Drivers d=new Drivers("Satyam","Tiwari","FrontEnd Developer");
        Vehicals v = new Vehicals();
        v.setVid(1234);
        v.setVedDesc("2008 model first generation");
        v.setVehName("Audi");
        d.setV(v);
        r.save(d);
    }

    @Override
    public void putOneToManyManually() {
        Drivers d=new Drivers("Hemanth","Shetty","BackEnd Developer");

        Phone phone1 =new Phone();
        phone1.setPhoneNo(913104991);
        phone1.setServiceProvider("Jio");
        phone1.setDriver(d);

        Phone phone2 =new Phone();
        phone2.setPhoneNo(903104991);
        phone2.setServiceProvider("Airtel");
        phone2.setDriver(d);

        List<Phone> phoneArrayList = new ArrayList<>();
        phoneArrayList.add(phone1);
        phoneArrayList.add(phone2);

        d.setPhoneList(phoneArrayList);
        r.save(d);


    }

    @Override
    public void putManyToManyManually() {
        Product product1 = new Product();
        product1.setPid("p1");
        product1.setpName("Iphone 14 pro max");

        Product product2 = new Product();
        product1.setPid("p2");
        product1.setpName("Samsung 15 pro max");

        Product product3 = new Product();
        product1.setPid("P3");
        product1.setpName("samsung TV 12345");

        Category category1 = new Category();
        category1.setCid("c1");
        category1.setCname("Electronics");

        Category category2 = new Category();
        category1.setCid("c2");
        category1.setCname("Mobile phones");


        List<Product>category1Product = category1.getProducts() ;
        category1Product.add(product1);
        category1Product.add(product2);
        category1Product.add(product3);

        List<Product>category2Product=category2.getProducts() ;
        category2Product.add(product1);
        category2Product.add(product2);
//        category1.setProducts(category1Product);
        cr.save(category1);
        cr.save(category2);






    }

}
