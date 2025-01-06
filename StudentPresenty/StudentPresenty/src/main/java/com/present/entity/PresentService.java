package com.present.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.present.dao.PresentRepository;
import com.present.exception.ResourceNotFoundException;

@Service
public class PresentService {

	@Autowired
	private PresentRepository presentRepository;

	public Student addStudent(Student student) {
		return presentRepository.save(student);
	}

	public List<Student> allStudents() {
		return presentRepository.findAll();
	}

	public Student findById(Integer rollNo) {
		Student foundStudent = presentRepository.findById(rollNo)
				.orElseThrow(() -> new ResourceNotFoundException("Roll No not Available "));

		return foundStudent;
	}

	public Student update(Integer rollNo, Student newStudent) {

		Student foundStudent = presentRepository.findById(rollNo)
				.orElseThrow(() -> new ResourceNotFoundException("Roll No not Available "));

		foundStudent.setName(newStudent.getName());
		foundStudent.setDate(newStudent.getDate());
		foundStudent.setPresent(newStudent.getPresent());

		presentRepository.save(foundStudent);
		return foundStudent;

	}

	public String delete(Integer rollNo) {
		Student foundStudent = presentRepository.findById(rollNo)
				.orElseThrow(() -> new ResourceNotFoundException("Roll No not Available "));

		if (foundStudent != null) {
			presentRepository.delete(foundStudent);
			return "Deleted!!";
		} else {
			return "Not Deleted";
		}

	}
}
