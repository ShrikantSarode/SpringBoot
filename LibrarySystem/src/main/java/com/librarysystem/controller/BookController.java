package com.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.entity.Book;
import com.librarysystem.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/bookBy/{id}")
	public Book getBookById(@PathVariable Integer id) {

		return bookService.getBookById(id);
	}

	@PostMapping("/add")
	public String addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return "Book added successfully";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
		return "Book Deleted";
	}
}
