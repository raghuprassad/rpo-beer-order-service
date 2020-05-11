package com.rpo.msscbeerorderservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rpo.msscbeerorderservice.domain.BeerOrder;
import com.rpo.msscbeerorderservice.domain.BeerOrderStatusEnum;
import com.rpo.msscbeerorderservice.domain.Customer;

/**
 * @author Raghavendra.Prasad
 *
 */
public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {
	
	Page<BeerOrder> findAllByCustomer(Customer customer, Pageable pageable);

    List<BeerOrder> findAllByOrderStatus(BeerOrderStatusEnum orderStatusEnum);
}
