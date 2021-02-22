package com.customerapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.model.Customer;
import com.customerapp.model.CustomerService;

@RestController
public class CustomerRest {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/api/customer", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> getAllBooks() {
		Collection<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/customer/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getAnBook(@PathVariable Integer id) {
		Customer book = customerService.getCustomerById(id);
		if (book == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Customer>(book, HttpStatus.OK);
	}
}
