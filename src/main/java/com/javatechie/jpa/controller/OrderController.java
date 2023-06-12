package com.javatechie.jpa.controller;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.entity.Product;
import com.javatechie.jpa.repository.CustomerRepository;
import com.javatechie.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
    @GetMapping("/getInfo/{productName}")
    public List<Product> findByProductName(@PathVariable String productName){
        return productRepository.findByProductName(productName);
    }
	/*
	 * @GetMapping("/getGender") public List<OrderResponse> getGender(){ return
	 * customerRepository.getJoinInformation2(); }
	 */
	/*
	 * @GetMapping("/findByname/{name}") public Customer
	 * findByname(@PathVariable("name") String productname,@RequestBody Customer
	 * customer){ Customer cu =(Customer)
	 * customerRepository.findByCity(productname,customer); if(cu != null) { String
	 * sql ="name is not displaying "; System.out.println(sql); } else {
	 * System.out.println("Name is Accepted showing success"); } return cu; }
	 */
	/*
	 * @GetMapping("/laptops") public ResponseEntity<List<Customer>> getData
	 * (@RequestParam String City) { return new
	 * ResponseEntity<List<Customer>>(customerRepository.findByCity(City),
	 * HttpStatus.OK); }
	 */
	/*
	 * @GetMapping("/getInfo/{productName}") public List<OrderResponse>
	 * getByproductname(@PathVariable String productName){ List<Customer>
	 * customerlist =customerRepository.getJoinInformation2(productName);
	 * List<OrderResponse> orderresponse =new ArrayList<>();
	 * customerlist.stream().forEach(customer ->{ orderresponse.add(new
	 * OrderResponse(customer)); }); return orderresponse; }
	 */
    
}
