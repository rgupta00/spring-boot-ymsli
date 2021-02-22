package com.productapp.service;

import java.util.List;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product getProductById(int id);
}