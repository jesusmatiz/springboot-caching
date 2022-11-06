package com.jms.cache.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty(value = "customer_id")
	private int customerId;
	@JsonProperty(value = "customer_name")
	private String customerName;

}
