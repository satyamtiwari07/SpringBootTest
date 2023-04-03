package com.example.Database.controller;

import com.example.Database.domain.Person;
import com.example.Database.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class PersonController {
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/register")
    public ModelAndView getRegisterPage(){
        return new ModelAndView("addUser", "person", new Person());
    }
    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String handleRegisterForm(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) throws SQLException {
        if(bindingResult.hasErrors()){
            return "addUser";
        }
        personService.addPerson(person);

        return "redirect:/";
    }

    @RequestMapping("/patients")
    public ModelAndView getUsersPage(){
        return new ModelAndView("patients","patients",personService.getAllPatients());
    }
}
