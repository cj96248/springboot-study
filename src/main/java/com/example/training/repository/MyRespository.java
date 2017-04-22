package com.example.training.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.training.domain.People;

public interface MyRespository<T> extends JpaRepository<People, Serializable>{
	
	public List<T> findByName(String name);
}
