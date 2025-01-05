package com.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.entity.Author;
import com.librarysystem.repository.IAuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private IAuthorRepository authorRepository;

	// add author
	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}

	// show all author
	public List<Author> allAuthor() {
		return authorRepository.findAll();
	}

	// delete by id
	public String deleteAuthorById(int authorId) {
		Author author = authorRepository.findById(authorId).orElse(null);
		if (author != null) {
			authorRepository.delete(author); // This will delete the author and associated books due to cascade
			return "Author and associated books deleted successfully";
		} else {
			return "Author not found";
		}
	}
}
