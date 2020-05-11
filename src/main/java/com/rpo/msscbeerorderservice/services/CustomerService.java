package com.rpo.msscbeerorderservice.services;

import org.springframework.data.domain.Pageable;

import com.rpo.msscbeerorderservice.model.CustomerDto;
import com.rpo.msscbeerorderservice.model.CustomerPagedList;

/**
 * @author Raghavendra.Prasad
 *
 */
public interface CustomerService {
	
	CustomerPagedList listCustomers(Pageable pageable);
	
	CustomerDto registerCustomer(CustomerDto customer);
}
