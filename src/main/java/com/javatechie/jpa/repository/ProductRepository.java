package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	public List<Product> findByProductName(String productName);

//	@Query("SELECT p FROM products p WHERE CONCAT(p.name, ' ', p.brand, ' ', p.madein, ' ', p.price) LIKE %?1%")
//	public List<Product> search(String keyword);
}
