package com.example.training.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.training.domain.People;

public interface MyRespository extends JpaRepository<People, Serializable>{

}
