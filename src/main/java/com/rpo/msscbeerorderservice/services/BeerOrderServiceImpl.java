package com.rpo.msscbeerorderservice.services;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rpo.msscbeerorderservice.domain.BeerOrder;
import com.rpo.msscbeerorderservice.domain.BeerOrderStatusEnum;
import com.rpo.msscbeerorderservice.domain.Customer;
import com.rpo.msscbeerorderservice.model.BeerOrderDto;
import com.rpo.msscbeerorderservice.model.BeerOrderPagedList;
import com.rpo.msscbeerorderservice.repositories.BeerOrderRepository;
import com.rpo.msscbeerorderservice.repositories.CustomerRepository;
import com.rpo.msscbeerorderservice.web.mappers.BeerOrderMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BeerOrderServiceImpl implements BeerOrderService {
	
	private final BeerOrderManager beerOrderManager;
	private final BeerOrderRepository beerOrderRepository;
	private final CustomerRepository customerRepository;
	private final BeerOrderMapper beerOrderMapper;

	@Override
	public BeerOrderPagedList listOrders(UUID customerId, Pageable pageable) {
		Optional<Customer> customerOptional  = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			Page<BeerOrder> beerOrderPage = 
					beerOrderRepository.findAllByCustomer(customerOptional.get(), pageable);
			
			
			return new BeerOrderPagedList(beerOrderPage
					.stream()
					.map(beerOrderMapper::beerOrderToDto)
					.collect(Collectors.toList()),PageRequest.of(
					beerOrderPage.getPageable().getPageNumber(),
					beerOrderPage.getPageable().getPageSize()),
					beerOrderPage.getTotalElements());
			 
		} else {
			return null;
		}
		
	}

	@Override
	public BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto) {
		Optional<Customer> customerOptional  = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			BeerOrder beerOrder = beerOrderMapper.dtoToBeerOrder(beerOrderDto);
            beerOrder.setId(null); //should not be set by outside client
            beerOrder.setCustomer(customerOptional.get());
            beerOrder.setOrderStatus(BeerOrderStatusEnum.NEW);
            
            beerOrder.getBeerOrderLines().forEach(line -> line.setBeerOrder(beerOrder));
            BeerOrder savedBeerOrder = beerOrderManager.newBeerOrder(beerOrder);
            
            log.debug("Saved Beer Order: " + beerOrder.getId());
            
            return beerOrderMapper.beerOrderToDto(savedBeerOrder);
		} else {
	        throw new RuntimeException("Customer Not Found");
		}
	}

	@Override
	public BeerOrderDto getOrderById(UUID customerId, UUID orderId) {
		Optional<Customer> customerOptional  = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			Optional<BeerOrder> beerOrderOptional = beerOrderRepository.findById(orderId);
			if (beerOrderOptional.isPresent()) {
				if(beerOrderOptional.get().getCustomer().getId().equals(customerId)) {
					return beerOrderMapper.beerOrderToDto(beerOrderOptional.get());
				}
			}
			throw new RuntimeException("Beer Order Not Found");
		}
		throw new RuntimeException("Customer Not Found");
	}

	@Override
	public void pickupOrder(UUID customerId, UUID orderId) {
	}

}
