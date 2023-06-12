package com.javatechie.jpa.repository;

import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();
	
	/*
	 * @Query("from Customer where products.productName =:productName") public
	 * List<Customer> findByCity(String productName, Customer customer);
	 */
	 /*@Query("SELECT new com.javatechie.jpa.dto.OrderResponse(c.price , p.productName) FROM Customer c JOIN c.products p"
	  ) public List<OrderResponse> getJoinInformation2();
	  */
	 

	/*
	 * @Query("select new com.javatechie.jpa.dto.OrderResponse(c.name , p.productName) from Customer c inner join products p on c.id =p.pid where p.productName=?"
	 * )
	 */
	// List<Customer> findByCity(String productName);

}
