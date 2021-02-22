package com.demo;

import java.util.Date;

public class Book {
	    private String bookID;
	    private String bookTitle;
	    private Date publicationDate;
		public Book(String bookID, String bookTitle, Date publicationDate) {
			super();
			this.bookID = bookID;
			this.bookTitle = bookTitle;
			this.publicationDate = publicationDate;
		}
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getBookID() {
			return bookID;
		}
		public void setBookID(String bookID) {
			this.bookID = bookID;
		}
		public String getBookTitle() {
			return bookTitle;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		public Date getPublicationDate() {
			return publicationDate;
		}
		public void setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate;
		}
		@Override
		public String toString() {
			return "Book [bookID=" + bookID + ", bookTitle=" + bookTitle
					+ ", publicationDate=" + publicationDate + "]";
		}
		
	    
	    
}
