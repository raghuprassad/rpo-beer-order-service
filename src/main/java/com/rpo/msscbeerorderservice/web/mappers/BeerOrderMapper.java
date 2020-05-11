package com.rpo.msscbeerorderservice.web.mappers;

import org.mapstruct.Mapper;

import com.rpo.msscbeerorderservice.domain.BeerOrder;
import com.rpo.msscbeerorderservice.model.BeerOrderDto;

/**
 * @author Raghavendra.Prasad
 *
 */
@Mapper(uses = {DateMapper.class})
public interface BeerOrderMapper {
	
	BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
