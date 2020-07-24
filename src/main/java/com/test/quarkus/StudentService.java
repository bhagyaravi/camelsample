package com.test.quarkus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;




public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Iterable<Student> getAllStudents(){
		return studentRepository.findAll();
	}
}
