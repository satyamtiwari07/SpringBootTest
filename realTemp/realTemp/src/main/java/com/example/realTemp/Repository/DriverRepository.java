package com.example.realTemp.Repository;


import com.example.realTemp.Entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Drivers, Integer> {
}
