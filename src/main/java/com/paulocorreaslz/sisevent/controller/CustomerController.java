package com.paulocorreaslz.sisevent.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paulocorreaslz.sisevent.model.Address;
import com.paulocorreaslz.sisevent.model.Customer;
import com.paulocorreaslz.sisevent.repo.AddressRepository;
import com.paulocorreaslz.sisevent.repo.CustomerRepository;
 
@CrossOrigin(origins = {"http://localhost:4200","http://localhost"})
@RestController
@RequestMapping("/api")
public class CustomerController {
 
  @Autowired
  CustomerRepository customerRepository;
  
  @Autowired
  AddressRepository addressRepository;
 
  @GetMapping("/customers")
  public List<Customer> getAllCustomers() {
    System.out.println("Get all Customers...");
 
    List<Customer> customers = new ArrayList<>();
    customerRepository.findAll().forEach(customers::add);
 
    return customers;
  }
 
  @PostMapping("/customer")
  public Customer postCustomer(@RequestBody Customer customer) {
 
	System.out.println("customer add:"+customer.toString());

	Customer _customer = customerRepository.save(new Customer(customer.getName(), customer.getAge()));
    return _customer;
  }
  
  @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/address")
  public Customer postAdress(@RequestBody Customer customer, Address address) {
 
	  System.out.println("customer recebido da view:"+customer.toString());
	  
	  Customer _customer = customerRepository.findOne(customer.getId());
	 			  
	  Address _address = addressRepository.save(new Address(customer.getAddress().getStreet(),customer.getAddress().getPlacenumber(),customer.getAddress().getPostalcode()));
	  
	  addressRepository.save(_address);
	  
	  _customer.setAddress(_address);
    
	  customerRepository.save(_customer);
      
	  return _customer;
  }
 
  @DeleteMapping("/customer/{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
    System.out.println("Delete Customer with ID = " + id + "...");
 
    Customer Customer = customerRepository.findOne(id);
    
    customerRepository.delete(Customer);
 
    return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
  }
 
  @GetMapping("customers/age/{age}")
  public List<Customer> findByAge(@PathVariable int age) {
 
    List<Customer> customers = customerRepository.findByAge(age);
    return customers;
  }
  
  @GetMapping("customers/name/{nome}")
  public List<Customer> getCustomersByName(@PathVariable String nome) {
    System.out.println("Get all Customers per name...");
 
    List<Customer> customers = customerRepository.findByName(nome);
 
    return customers;
  }
 
  @PutMapping("/customer/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
    System.out.println("Update Customer with ID = " + id + "...");
 
   Customer customerData = customerRepository.findOne(id);

   if (customerData != null) {
    Customer _customer = customerData;
     _customer.setName(customer.getName());
      _customer.setAge(customer.getAge());
      _customer.setActive(customer.isActive());
      return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}