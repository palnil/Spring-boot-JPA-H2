package helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
