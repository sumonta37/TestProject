package com.delight.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delight.demo.entity.Student;
import com.delight.demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@PostMapping("/saveStudent")
	public Student savePerson(@RequestBody Student student) {
		return repository.addStudent(student);
	}

	@GetMapping("/getStudent/{studentId}")
	public Student findStudentRecords(@PathVariable String studentId) {
		return repository.findStudentByStudentId(studentId);
	}

	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@RequestBody Student Student) {
		return repository.deletePerson(Student);
	}

	@PutMapping("/editStudent")
	public String updateStudent(@RequestBody Student student) {
		return repository.editStudentDetails(student);
	}

}
