package com.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.entity.Book;
import com.librarysystem.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	

	// get all books
	public List<Book> getAllBooks() {
		List<Book> allBooks = bookRepository.findAll();
		return allBooks;
	}

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	// get book by id
	public Book getBookById(Integer id) {
		Book found = bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book of id " + id + " not available"));
		return found;
	}

	// delete Book by id
	public String deleteBook(Integer id) {

		Book found = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Id of book not found"));

		bookRepository.delete(found);
		return "Book Deleted with Id: " + id;

	}

}
