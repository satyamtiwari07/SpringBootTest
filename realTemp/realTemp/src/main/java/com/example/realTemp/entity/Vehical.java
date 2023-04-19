package com.example.realTemp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Vehical_details")
public class Vehical {

    @Id
    @Column(name="vehical_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID vehicalId;

    @Column(name="vehicle_name")
    String vehicleName;

    @Column(name="vehicle_price")
    long price;

    @Column(name="vehicle_description")
    String vehicalDescription;

    @OneToOne
    @JoinColumn(name = "driver_id")
    Drivers drivers;

}
