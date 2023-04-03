package com.example.Database.service;

import com.example.Database.domain.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    List<Person> getAllPatients();
    Person getPersonById(int id);
    void updatePersonCovidInfo(int id);
    void deletePersonById(int id);
}
