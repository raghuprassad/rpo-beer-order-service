package com.rpo.msscbeerorderservice.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rpo.msscbeerorderservice.domain.BeerOrderLine;

/**
 * @author Raghavendra.Prasad
 *
 */
public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {
	
}
