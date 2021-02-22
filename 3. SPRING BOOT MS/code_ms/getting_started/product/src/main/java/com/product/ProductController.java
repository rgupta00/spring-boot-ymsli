package com.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping("/product")
	public String HelloWorld() {
		return "product information...instance 1";
	}

}