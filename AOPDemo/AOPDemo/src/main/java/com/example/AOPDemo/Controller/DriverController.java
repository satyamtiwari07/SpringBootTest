package com.example.AOPDemo.Controller;
import com.example.AOPDemo.Entity.Drivers;
import com.example.AOPDemo.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/add/employee", method = RequestMethod.GET)
    public Drivers addEmployee(@RequestParam("driverId") String driverId, @RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName)
    {
        return driverService.createEmployee(driverId, firstName, secondName);
    }
    @RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
    public String removeEmployee( @RequestParam("DriverId") String driverId)
    {
        driverService.deleteEmployee(driverId);
        return "Employee removed";
    }


}
