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

import com.example.training.domain.MyResult;
import com.example.training.domain.People;
import com.example.training.repository.MyRespository;
import com.example.training.util.MyResultUtil;

@RestController
public class MyController {

	@Autowired
	private MyRespository<People> repository;

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
	public MyResult<Object> insertPeople(@Valid People people, BindingResult result) {
		if (result.hasErrors()) {
			
			return MyResultUtil.failed(result.getFieldError().getDefaultMessage());
		}
		people.setName(people.getName());
		people.setAge(people.getAge());
		
		
		return MyResultUtil.success(repository.save(people));
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
	
	public List<People> getPersonByName(@PathVariable("name") String name){
		return repository.findByName(name);
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
