package com.orderapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.model.Coupon;
import com.orderapp.model.Customer;
import com.orderapp.model.Order;
import com.orderapp.model.Product;

@RestController
public class OrderRest {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/api/order", 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> submitOrder(@RequestParam("pid")int pid, @RequestParam("cid")int cid){
		Order order = new Order();
		
		String couponUrl="http://localhost:8085/coupon/api/coupon/SUP10";
		
		String custUrl="http://localhost:8081/customer/api/customer/"+cid;
		System.out.println(custUrl);
		String productUrl="http://localhost:8082/product/api/product/"+pid;
		System.out.println(productUrl);
		Customer customer = restTemplate.getForObject(custUrl, Customer.class,cid);
		
		Product product = restTemplate.getForObject(productUrl, Product.class,pid);
		
		Coupon coupon=restTemplate.getForObject(couponUrl, Coupon.class);
		
	
		order.setCustomer(customer);
		order.setProduct(product);
		order.setId(1);
		long amount= (long) product.getPrice()*(100-coupon.getDiscount());
		
		order.setAmount(amount);
		order.setDateOrder(new Date());
		System.out.println("------------------------------");
		System.out.println(order);
		System.out.println(coupon);		
		System.out.println("------------------------------");
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
}
