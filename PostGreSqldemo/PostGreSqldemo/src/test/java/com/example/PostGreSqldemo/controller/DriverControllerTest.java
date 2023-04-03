package com.example.PostGreSqldemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class DriverControllerTest {

    DriverController dc = new DriverController();

    @Test
    public void testGetMethod()
    {
        String url ="http://localhost:4567/drivers";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity=restTemplate.getForEntity(url,String.class,dc);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

        System.out.println(responseEntity.getBody());

    }

}