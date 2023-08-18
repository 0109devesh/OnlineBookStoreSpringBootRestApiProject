package com.example.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
