package com.example.realTemp.service;

import com.example.realTemp.config.MessageConfig;
import com.example.realTemp.entity.OrderStatus;
import com.example.realTemp.entity.Vehical;
import com.example.realTemp.entity.VehicalDto;
import com.example.realTemp.exception.VehicalNotFoundException;
import com.example.realTemp.repository.VehicalRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicalServiceImpl implements VehicalService {

    @Autowired
    VehicalRepository vehicalRepository;

    @Autowired
    DriverServiceImpl driverService;

    @Autowired
    private RabbitTemplate template;

    @Override
    public VehicalDto SaveVehical(VehicalDto vehicalDto) {

        Vehical v= Vehical.builder()
                .vehicleName(vehicalDto.getVehicalName())
                .price(vehicalDto.getPrice())
                .vehicalDescription(vehicalDto.getVehicalDescription())
                .drivers(vehicalDto.getDrivers())
                .build();
        vehicalRepository.save(v);

        Vehical t = findVehicalById(v.getVehicalId());
        OrderStatus orderStatus = new OrderStatus(t, "PROCESS", "order placed succesfully" );
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, orderStatus);
        System.out.println( "Success !!");

//        vehicalDto.getD().addlist(v);
//        ds.updateDriver(vehical.getD(),vehical.getD().getId());

//        ds.updateDriverVehicalList(vehicalDto.getD().getId(),vehicalDto.getD(),v);

        return vehicalDto;
    }

    @Override
    public List<VehicalDto> GetAllVehicals() {

        List<Vehical>temp = vehicalRepository.findAll();
        List<VehicalDto>allVehicals = new ArrayList<>();
        for (Vehical v: temp) {
            VehicalDto vt = VehicalDto.builder()
                    .vehicalName(v.getVehicleName())
                    .price(v.getPrice())
                    .vehicalDescription(v.getVehicalDescription())
                    .build();
            allVehicals.add(vt);
        }
        return allVehicals;
    }

    @Override
    public Vehical findVehicalById(UUID id) {

        Vehical v =   vehicalRepository.findById(id).orElseThrow(()->new VehicalNotFoundException("Cannot Find vehical with Id:" + id));
        return v;
    }

}
