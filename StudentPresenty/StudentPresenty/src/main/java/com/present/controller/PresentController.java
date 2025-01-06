package com.present.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.present.entity.PresentService;
import com.present.entity.Student;
import com.present.exception.ResourceNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class PresentController {

	@Autowired
	private PresentService presentService;

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		return new ResponseEntity<>(presentService.addStudent(student), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> allStudent() {
		return new ResponseEntity<>(presentService.allStudents(), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Student found = presentService.findById(id);

		return ResponseEntity.ok(found); // Return the found student with status 200 OK
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return new ResponseEntity<>(presentService.delete(id), HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Student newStudent) {

		Student found = presentService.update(id, newStudent);
		return ResponseEntity.ok(found);
	}

}
