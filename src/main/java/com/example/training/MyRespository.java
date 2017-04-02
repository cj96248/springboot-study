package com.example.training;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRespository extends JpaRepository<People, Serializable>{

}
