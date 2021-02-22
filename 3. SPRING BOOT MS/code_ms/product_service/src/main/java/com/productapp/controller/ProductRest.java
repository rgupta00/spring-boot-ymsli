package com.productapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.service.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductRest {

		@Autowired
		private ProductService productService;

		@RequestMapping(value = "/api/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<Product>> getAllBooks() {
			Collection<Product> greetings = productService.getAllProducts();
			return new ResponseEntity<Collection<Product>>(greetings, HttpStatus.OK);
		}

		@RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Product> getAnBook(@PathVariable Integer id) {
			Product product = productService.getProductById(id);
			if (product == null) {
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
}
