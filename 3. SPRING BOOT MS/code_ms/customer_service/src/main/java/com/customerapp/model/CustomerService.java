package com.customerapp.model;

import java.util.List;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
}