package com.example.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.bookstore.entities.Book;
import com.example.bookstore.repositories.BookRepository;

@Service
public class BookService {

	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll(); 
	}
	
	
	public Book getBook(Long bookId) {
		return bookRepository.findById(bookId)
				 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

	}
	
	public Book registerBook(Book book) {
		
		return bookRepository.save(book);
		
	}
	
	
	
	
}
