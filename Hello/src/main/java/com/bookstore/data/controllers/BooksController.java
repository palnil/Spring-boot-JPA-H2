package com.bookstore.data.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.data.domain.Book;
import com.bookstore.data.repository.BookRepository;

@RestController
@RequestMapping("/")
public class BooksController {
	

	private BookRepository repo;
	
	public BooksController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/books")
	public Iterable<Book> allBook() {

		return repo.findAll();
		
	}
	
}
