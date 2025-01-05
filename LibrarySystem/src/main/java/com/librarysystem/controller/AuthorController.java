package com.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.entity.Author;
import com.librarysystem.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/add")
	public ResponseEntity<?> addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
		return new ResponseEntity<>("Author added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Author> allAuthor() {

		return authorService.allAuthor();

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
		authorService.deleteAuthorById(id);
		return new ResponseEntity<>("Author Deleted!!", HttpStatus.OK);
	}

}
