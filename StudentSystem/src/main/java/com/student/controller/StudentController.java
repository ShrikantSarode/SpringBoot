package com.student.controller;

import java.util.List;

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

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {

		return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> allStudent() {
		return new ResponseEntity<>(studentService.allStudent(), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Student newStudent) {
//		return new ResponseEntity<>(studentService.updateStudent(id, newStudent), HttpStatus.CREATED);

		Student updatedStudent = studentService.updateStudent(id, newStudent);
		if (updatedStudent != null) {
			return ResponseEntity.ok(updatedStudent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
//		return new ResponseEntity<>(studentService.delete(id), HttpStatus.OK);
		String deleteFound = studentService.delete(id);

		if (deleteFound != null) {
			return ResponseEntity.ok(deleteFound);
		}
		return ResponseEntity.notFound().build();
	}

}
