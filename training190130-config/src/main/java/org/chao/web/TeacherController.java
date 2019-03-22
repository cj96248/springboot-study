package org.chao.web;

import java.util.concurrent.TimeUnit;

import org.chao.entity.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TeacherController {

	@GetMapping("/teacher/{id}")
	public Teacher findById(@PathVariable int id) throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		return new Teacher().setId(id).setName("Hleen");
	}
	
	@PostMapping("/save/teacher")
	public Teacher save(@RequestBody Teacher teacher){
		log.info(teacher.toString());
		return teacher;
	}
}
