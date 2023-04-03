package com.example.drivername.repository;

import com.example.drivername.model.Driver;

import java.util.List;

public interface searchrepo {
    List<Driver> searchtext(String text);
}
