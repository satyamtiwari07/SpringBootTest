package com.example.ReactiveWithPostGresSql.repository;


import com.example.ReactiveWithPostGresSql.entity.Driver;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends ReactiveCrudRepository<Driver, Integer> {
}
