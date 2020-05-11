package com.rpo.msscbeerorderservice.services;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rpo.msscbeerorderservice.domain.Customer;
import com.rpo.msscbeerorderservice.model.CustomerDto;
import com.rpo.msscbeerorderservice.model.CustomerPagedList;
import com.rpo.msscbeerorderservice.repositories.CustomerRepository;
import com.rpo.msscbeerorderservice.web.mappers.CustomerMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Raghavendra.Prasad
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerPagedList listCustomers(Pageable pageable) {

        Page<Customer> customerPage = customerRepository.findAll(pageable);

        return new CustomerPagedList(customerPage
                        .stream()
                        .map(customerMapper::customerToDto)
                        .collect(Collectors.toList()),
                    PageRequest.of(customerPage.getPageable().getPageNumber(),
                        customerPage.getPageable().getPageSize()),
                        customerPage.getTotalElements());
    }

	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
		Customer customer = customerMapper.dtoToCustomer(customerDto);
		customer.setApiKey(UUID.randomUUID());
		 if (customerRepository.findAllByCustomerNameLike(customer.getCustomerName()) .size() == 0) {
	            Customer savedCustomer = customerRepository.saveAndFlush(customer);
	            log.debug("Tasting Room Customer Id: " + savedCustomer.getId().toString());
	        }
		return null;
	}
}
