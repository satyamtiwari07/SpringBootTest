package com.javatechie.rabbitmq.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Vehical {

    private String vehicalId;
    private String name;
    private int qty;
    private double price;
    private String email;
}
