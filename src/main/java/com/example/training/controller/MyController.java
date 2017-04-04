package com.example.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.domain.People;
import com.example.training.repository.MyRespository;

@RestController
public class MyController {

	@Autowired
	private MyRespository repository;

	/**
	 * 查询所有数据
	 * 
	 * @return List
	 */
	@GetMapping("/findList")
	public List<People> findPeople() {
		return repository.findAll();

	}

	/**
	 * 添加一条数据
	 * 
	 * @param id,name,age
	 * @return 所添加的数据
	 */
	@PostMapping("/insert")
	public People insertPeople(@Valid People people, BindingResult result) {
		if (result.hasErrors()) {
			String eString = result.getFieldError().getDefaultMessage();
			System.out.println(eString);
			return null;
		}
		people.setName(people.getName());
		people.setAge(people.getAge());
		return repository.save(people);
	}

	/**
	 * 查询一条数据
	 * 
	 * @param id
	 * @return 一条数据
	 */
	@GetMapping(value = "/find/{id}")
	public People getPerson(@PathVariable("id") Integer id) {
		return repository.findOne(id);
	}

	/**
	 * 更新一条数据
	 * 
	 * @param is,name,age
	 * @return 更新的数据
	 */
	@PutMapping(value = "/update/{id}")
	public People updatePerson(@PathVariable("id") Integer id, @RequestParam("name") String name,
			@RequestParam("age") Integer age) {
		People people = new People();
		people.setId(id);
		people.setName(name);
		people.setAge(age);
		return repository.save(people);
	}

	/**
	 * 删除一条数据
	 * 
	 * @param id
	 */
	@PutMapping("/delete/{id}")
	public void deletePerson(@PathVariable("id") Integer id) {
		repository.delete(id);
	}
}
