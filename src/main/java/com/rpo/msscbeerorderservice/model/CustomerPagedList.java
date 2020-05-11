package com.rpo.msscbeerorderservice.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * @author Raghavendra.Prasad
 *
 */
public class CustomerPagedList extends PageImpl<CustomerDto>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 236550814028828244L;

	public CustomerPagedList(List<CustomerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public CustomerPagedList(List<CustomerDto> content) {
		super(content);
	}
}
