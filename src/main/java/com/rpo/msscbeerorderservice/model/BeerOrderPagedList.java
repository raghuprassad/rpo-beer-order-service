package com.rpo.msscbeerorderservice.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerOrderPagedList extends PageImpl<BeerOrderDto> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4692828290068572255L;

	public BeerOrderPagedList(List<BeerOrderDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public BeerOrderPagedList(List<BeerOrderDto> content) {
		super(content);
	}
}
