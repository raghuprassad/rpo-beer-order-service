package com.rpo.msscbeerorderservice.web.mappers;

import org.mapstruct.Mapper;

import com.rpo.msscbeerorderservice.domain.BeerOrderLine;
import com.rpo.msscbeerorderservice.model.BeerOrderLineDto;

/**
 * @author Raghavendra.Prasad
 *
 */
@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
	
	BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
