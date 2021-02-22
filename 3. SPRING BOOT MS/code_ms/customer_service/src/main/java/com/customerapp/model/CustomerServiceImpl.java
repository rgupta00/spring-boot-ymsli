package com.customerapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService{
private static Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	
	static{
		customers.put(1, new Customer(1, "amit", "amit@gmail.com"));
		customers.put(2, new Customer(2, "sumit", "sumit@gmail.com"));
	}
	@Override
	public List<Customer> getAllCustomers() {
		return new ArrayList<Customer>(customers.values());
	}

	@Override
	public Customer getCustomerById(int id) {
		return customers.get(id);
	}

}
