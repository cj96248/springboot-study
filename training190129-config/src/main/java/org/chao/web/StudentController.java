package org.chao.web;

import org.chao.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping("/student/{id}")
	public Student findById(@PathVariable int id) {
		return new Student().setId(id).setName("Tom");
	}
}
