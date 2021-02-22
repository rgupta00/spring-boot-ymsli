package com.demo;
public class BookNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(String msg){
		super(msg);
	}
	
	public BookNotFoundException(String msg, Throwable throwable){
		super(msg, throwable);
	}
	

}