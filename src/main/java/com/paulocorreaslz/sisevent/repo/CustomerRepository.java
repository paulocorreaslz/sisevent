package com.paulocorreaslz.sisevent.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
 
import com.paulocorreaslz.sisevent.model.*;;
 
public interface CustomerRepository extends CrudRepository<Customer, Long> {
  
	List<Customer> findByAge(int age);
	
	List<Customer> findByName(String nome);
	
}