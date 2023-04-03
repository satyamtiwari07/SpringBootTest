package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

        //this statement creates the container
        ConfigurableApplicationContext cnt = SpringApplication.run(DemoApplication.class, args);
        driver d = cnt.getBean(driver.class);
        d.show();
	}

}
