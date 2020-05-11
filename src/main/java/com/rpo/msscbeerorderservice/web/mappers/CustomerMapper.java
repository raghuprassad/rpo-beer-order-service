package com.rpo.msscbeerorderservice.web.mappers;

import org.mapstruct.Mapper;

import com.rpo.msscbeerorderservice.domain.Customer;
import com.rpo.msscbeerorderservice.model.CustomerDto;

/**
 * @author Raghavendra.Prasad
 *
 */
@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {
	
	CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(CustomerDto dto);
}
