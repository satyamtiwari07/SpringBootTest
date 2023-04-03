package com.mapping.Repository;

import com.mapping.Entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Drivers,Integer> {
}
