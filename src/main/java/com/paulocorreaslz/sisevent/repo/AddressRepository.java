package com.paulocorreaslz.sisevent.repo;

import org.springframework.data.repository.CrudRepository;
 
import com.paulocorreaslz.sisevent.model.*;;

public interface AddressRepository extends CrudRepository<Address, Long> {

	Address findById(int id);

}