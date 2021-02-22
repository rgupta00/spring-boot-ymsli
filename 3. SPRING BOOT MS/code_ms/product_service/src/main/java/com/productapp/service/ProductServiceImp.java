package com.productapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
	private static Map<Integer, Product> products = new HashMap<Integer, Product>();
	static {
		products.put(1, new Product(1, "tv", 56));
		products.put(2, new Product(1, "laptop", 76));

	}

	@Override
	public List<Product> getAllProducts() {

		return new ArrayList<Product>(products.values());
	}

	@Override
	public Product getProductById(int id) {
		return products.get(id);
	}

}
