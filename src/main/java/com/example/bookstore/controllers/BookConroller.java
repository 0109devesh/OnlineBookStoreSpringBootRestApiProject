package com.example.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entities.Book;
import com.example.bookstore.services.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class BookConroller {

	// http://localhost:8085/books

	@Autowired
	private BookService bookService;

	@GetMapping("/books-list")
	public List<Book> getAllBooks() {

		return this.bookService.getAllBooks();
	}

	@GetMapping("/book/{bookId}")
	public Book getBook(@PathVariable Long bookId) {

		return bookService.getBook(bookId);
	}

	@PostMapping("/register-book")
	public ResponseEntity<Book> registerBook(@RequestBody Book book) {

		Book resgisteredBook = this.bookService.registerBook(book);

		if (resgisteredBook != null) {
			return ResponseEntity.ok(resgisteredBook);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

}
