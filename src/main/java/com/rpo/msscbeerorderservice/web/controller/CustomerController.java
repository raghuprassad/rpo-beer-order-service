package com.rpo.msscbeerorderservice.web.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rpo.msscbeerorderservice.model.CustomerDto;
import com.rpo.msscbeerorderservice.model.CustomerPagedList;
import com.rpo.msscbeerorderservice.services.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Raghavendra.Prasad
 *
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {
	
	private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final CustomerService customerService;

    @GetMapping
    public CustomerPagedList listCustomers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
    	
    	log.info("<<<<<<<<<<<<<<<< REQUST SUCCESSFULY INVOKED WITH PAGE NUMBER {} AND PAGE SiZE {} >>>>>>>>>>>>>>>>>", pageNumber , pageSize);

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        return customerService.listCustomers(PageRequest.of(pageNumber, pageSize));
    }
    
    @PostMapping
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto customerdto) {
    	
    	log.debug("<<<<<<<<<<<<<<< Customer paylod >>>>>>>>>>>>", customerdto.toString());
    	
    	CustomerDto customerDto = customerService.registerCustomer(customerdto);
    	
    	return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
}
