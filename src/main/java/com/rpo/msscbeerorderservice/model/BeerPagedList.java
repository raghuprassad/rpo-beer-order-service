package com.rpo.msscbeerorderservice.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPagedList extends PageImpl<BeerDto> implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966863330621128345L;

	public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public BeerPagedList(List<BeerDto> content) {
		super(content);
	}
}
