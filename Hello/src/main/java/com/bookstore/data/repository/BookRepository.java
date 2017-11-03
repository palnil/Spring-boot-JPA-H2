package com.bookstore.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.data.domain.Book;



public interface BookRepository extends CrudRepository<Book, Long>{
	
	public Book findByIsbn(String isbn);

}
