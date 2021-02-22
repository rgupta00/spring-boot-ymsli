package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/order")
	public String callService() {
		String customerInfo= 
				restTemplate.getForEntity("http://localhost:8081/customer", String.class).getBody();
		String productInfo= 
				restTemplate.getForEntity("http://localhost:8082/product", String.class).getBody();
		
		return customerInfo.concat(" ").concat(productInfo);
	}

}