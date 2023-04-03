package com.mapping.Repository;

import com.mapping.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,String> {
}
