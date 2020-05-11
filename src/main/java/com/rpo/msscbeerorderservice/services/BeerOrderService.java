package com.rpo.msscbeerorderservice.services;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.rpo.msscbeerorderservice.model.BeerOrderDto;
import com.rpo.msscbeerorderservice.model.BeerOrderPagedList;

/**
 * @author Raghavendra.Prasad
 *
 */
public interface BeerOrderService {
	
	BeerOrderPagedList listOrders(UUID customerId, Pageable pageable);

    BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);

    BeerOrderDto getOrderById(UUID customerId, UUID orderId);

    void pickupOrder(UUID customerId, UUID orderId);
}
