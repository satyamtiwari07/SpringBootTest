package com.example.drivername.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.drivername.model.Driver;

public interface PostRepo extends MongoRepository<Driver,String>
{

}
