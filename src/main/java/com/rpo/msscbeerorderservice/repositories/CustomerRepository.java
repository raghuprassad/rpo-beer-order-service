package com.rpo.msscbeerorderservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpo.msscbeerorderservice.domain.Customer;

/**
 * @author Raghavendra.Prasad
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
	
	List<Customer> findAllByCustomerNameLike(String customerName);
}
