package com.example.AOPDemo.Aspact;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DriverAspect {
    @Before(value = "execution(* com.example.AOPDemo.Service.DriverService.*(..)) and args(driverId, fname, sname)")
    public void beforeAdvice(JoinPoint joinPoint, String driverId, String fname, String sname) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Creating Driver with first name - " + fname + ", second name - " + sname + " and id - " + driverId);
    }

    @After(value = "execution(* com.example.AOPDemo.Service.DriverService.*(..)) and args(driverId, fname, sname)")
    public void afterAdvice(JoinPoint joinPoint, String driverId, String fname, String sname) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("Creating Driver with first name - " + fname + ", second name - " + sname + " and id - " + driverId);
    }


}
