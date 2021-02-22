package com.demo;

import java.io.IOException;
import java.util.Date;

import com.google.gson.Gson;

public class App {
	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();

		Book book1 = new Book("B1", "Java Programming Book", new Date());
		Book book2 = new Book("B2", "C++ Programming Book",
				 new Date());

		
		  //serialization
        String jsonBook1 = gson.toJson(book1);
        System.out.println("Book1: "+book1);
        System.out.println("Json Book1: "+jsonBook1);
        
        String jsonBook2 = gson.toJson(book2);
        System.out.println("Book2: "+book2);
        System.out.println("Json Book1: "+jsonBook2);
        
        
        //deserialization
        jsonBook1 = gson.toJson(book1);
        Book b1 = gson.fromJson(jsonBook1, Book.class);
        System.out.println("b1: "+b1);
        
        Library lib = new Library();
        lib.books.add(book1);
        lib.books.add(book2);
        lib.books.add(b1);
        lib.saveToJsonFile("Books.json");
	}
}
