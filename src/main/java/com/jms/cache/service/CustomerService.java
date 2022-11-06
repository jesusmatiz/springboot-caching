package com.jms.cache.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.jms.cache.dto.CustomerDTO;
import com.jms.cache.entity.Customer;
import com.jms.cache.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Cacheable("customers")
	public List<CustomerDTO> all() {
		
		List<CustomerDTO> customers = new ArrayList<>();
		
		List<Customer> cList = this.customerRepository.findAll();
		
		cList.forEach(d -> {
			
			CustomerDTO dto = new CustomerDTO();
			
			dto.setCustomerId(d.getCustomerId());
			dto.setCustomerName(d.getCustomerName());
			
			customers.add(dto);
		});
		
		return customers;
	}
	
	@Caching(evict = {
			@CacheEvict(value = "customers", allEntries = true)			
	})
	public void save(CustomerDTO dto) {
		
		Customer customer = new Customer();
		customer.setCustomerName(dto.getCustomerName());
		
		this.customerRepository.save(customer);
	}

}
