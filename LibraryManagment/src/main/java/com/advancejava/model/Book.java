package com.advancejava.model;


public class Book {
	
	private int bookId;

	private String bookName;

	private String authorName;

	private String currentDate;

	public Book() {
		
	}
	public int getBookCode() {
		return bookId;
	}

	public void setBookCode(int bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDate() {
		return currentDate;
	}

	public void setDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public Book(int bookId, String bookName, String author, String currentDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = author;
		this.currentDate = currentDate;
	}

}