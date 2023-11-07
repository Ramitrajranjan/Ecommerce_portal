package com.e_Commerce.repository;

import com.e_Commerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Page<Product> findAll(Pageable pageable);
    public Page<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionIgnoreCase(String Key1,String Key2,Pageable pageable);
}
