package com.bookstore.data.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.data.domain.Book;
import com.bookstore.data.repository.BookRepository;

@RestController
@RequestMapping("/")
public class BooksController {

	private BookRepository repo;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public BooksController(BookRepository repo) {
		this.repo = repo;
	}

	// returns all books library has
	@GetMapping("/books")
	public Iterable<Book> allBook() {

		// Code snippet to test different log levels in log file
		logger.debug("Debug Level :: BooksContoller : allBook()");
		logger.info("Info Level :: BooksContoller : allBook()");
		logger.warn("Warn Level :: BooksContoller : allBook()");
		logger.error("Error Level :: BooksContoller : allBook()");

		return repo.findAll();

	}

	// returns book by isbn provided
	@GetMapping("/books/{isbn}")
	public Book getBookByISBN(@PathVariable String isbn) {

		logger.debug("ISBN received by controller is " + isbn);
		return repo.findByIsbn(isbn);
	}

	// save a book
	@PostMapping("/book")
	public String save(@RequestBody Book book) {

		logger.debug("Book Received by Post Request is " + book);
		repo.save(book);
		logger.debug("Book saved successfully in Database");
		return "Book saved successfully in Database";
	}

}
