package com.example.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_table")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column
	private String bookName;
	
	@Column
	private String author;
	
	@Column
	private double price;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long bookId, String bookName, String author, double price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	
	
}
