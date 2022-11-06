package com.jms.cache.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jms.cache.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	@Transactional(readOnly = true)
	@Override
	List<Customer> findAll();

}
