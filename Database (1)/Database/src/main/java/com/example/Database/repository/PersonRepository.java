package com.example.Database.repository;

import com.example.Database.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Transactional
    @Modifying
    @Query("update Person p set p.covidInfo = :covidInfo where p.id = :id")
    void setCovidInfo(@Param("covidInfo") String covidInfo, @Param("id") int id);

    Person findByName(String name);
}
