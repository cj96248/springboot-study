package com.example.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	@Autowired
	private People people;
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	private String syaHello() {
		return people.getContent();

	}
}
