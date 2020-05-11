package com.rpo.msscbeerorderservice.services;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rpo.msscbeerorderservice.domain.BeerOrder;
import com.rpo.msscbeerorderservice.domain.BeerOrderStatusEnum;
import com.rpo.msscbeerorderservice.model.BeerOrderDto;
import com.rpo.msscbeerorderservice.repositories.BeerOrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service
public class BeerOrderManagerImpl implements BeerOrderManager {
	
	private final BeerOrderRepository beerOrderRepository;
	
	@Transactional
	@Override
	public BeerOrder newBeerOrder(BeerOrder beerOrder) {
		beerOrder.setId(null);
        beerOrder.setOrderStatus(BeerOrderStatusEnum.NEW);

        BeerOrder savedBeerOrder = beerOrderRepository.saveAndFlush(beerOrder);
        
        //sendBeerOrderEvent(savedBeerOrder, BeerOrderEventEnum.VALIDATE_ORDER);
        return savedBeerOrder;
	}

	@Override
	public void processValidationResult(UUID beerOrderId, Boolean isValid) {
	}

	@Override
	public void beerOrderAllocationPassed(BeerOrderDto beerOrder) {
	}

	@Override
	public void beerOrderAllocationPendingInventory(BeerOrderDto beerOrder) {
	}

	@Override
	public void beerOrderAllocationFailed(BeerOrderDto beerOrder) {
	}

	@Override
	public void beerOrderPickedUp(UUID id) {
	}

	@Override
	public void cancelOrder(UUID id) {
	}

}
