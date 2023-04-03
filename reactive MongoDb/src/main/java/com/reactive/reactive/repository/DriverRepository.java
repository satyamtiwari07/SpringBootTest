package com.reactive.reactive.repository;

import com.reactive.reactive.entity.Driver;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends ReactiveCrudRepository<Driver, String> {
}
