package com.example.Database.service;


import com.example.Database.domain.Person;
import com.example.Database.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> getAllPatients() {
        List<Person> peopleList = personRepository.findAll();
        return peopleList;
    }

    @Override
    public Person getPersonById(int id) {
        return personRepository.getOne(id);
    }

    @Override
    public void updatePersonCovidInfo(int id) {
        personRepository.setCovidInfo("Negative",id);
    }

    @Override
    public void deletePersonById(int id) {

    }

}
