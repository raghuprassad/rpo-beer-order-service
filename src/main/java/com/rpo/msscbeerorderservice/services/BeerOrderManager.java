package com.rpo.msscbeerorderservice.services;

import java.util.UUID;

import com.rpo.msscbeerorderservice.domain.BeerOrder;
import com.rpo.msscbeerorderservice.model.BeerOrderDto;

/**
 * @author Raghavendra.Prasad
 *
 */
public interface BeerOrderManager {
	
	BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID beerOrderId, Boolean isValid);

    void beerOrderAllocationPassed(BeerOrderDto beerOrder);

    void beerOrderAllocationPendingInventory(BeerOrderDto beerOrder);

    void beerOrderAllocationFailed(BeerOrderDto beerOrder);

    void beerOrderPickedUp(UUID id);

    void cancelOrder(UUID id);
}
