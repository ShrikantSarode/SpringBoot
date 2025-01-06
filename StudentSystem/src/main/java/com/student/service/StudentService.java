package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// add
	public Student addStudent(Student student) {

		return studentRepository.save(student);
	}

	// all
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}

	// find id
	public Student findById(Integer id) {
		Student found = studentRepository.findById(id).orElse(null);

		if (found != null) {
			return found;
		} else {
			return null;
		}
	}

	// update
	public Student updateStudent(Integer id, Student newStudent) {
		Student findStudent = studentRepository.findById(id).orElse(null);
		if (findStudent != null) {

			findStudent.setFname(newStudent.getFname());
			findStudent.setLname(newStudent.getLname());
			findStudent.setStream(newStudent.getStream());
		}
		return studentRepository.save(findStudent);

	}

	// delete
	public String delete(Integer id) {
		Student findStudent = studentRepository.findById(id).orElse(null);

		if (findStudent != null) {
			studentRepository.delete(findStudent);
			return "Deleted!!";
		}
		return "Not Found";
	}

}
