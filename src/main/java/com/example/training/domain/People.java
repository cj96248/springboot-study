package com.example.training.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class People {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@Min(value = 8 , message = "年龄太小，不能注册")
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

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
