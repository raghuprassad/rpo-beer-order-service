package com.rpo.msscbeerorderservice.domain;

/**
 * @author Raghavendra.Prasad
 *
 */
public enum BeerOrderEventEnum {
	
	VALIDATE_ORDER, CANCEL_ORDER, VALIDATION_PASSED, VALIDATION_FAILED,
    ALLOCATE_ORDER, ALLOCATION_SUCCESS, ALLOCATION_NO_INVENTORY, ALLOCATION_FAILED,
    BEERORDER_PICKED_UP
}
