package com.chao.training0129.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chao.training0129.entity.Student;

@RestController
public class StudentController {

	@GetMapping("/student/{id}")
	public Student findById(@PathVariable int id) {
		return new Student().setId(id).setName("Tom");
	}
}
