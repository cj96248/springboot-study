package com.example.training;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class People {
	
	@Id
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	public People() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
