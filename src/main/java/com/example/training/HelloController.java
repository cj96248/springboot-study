package com.example.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/asset")
public class HelloController {
	
/*	@Autowired
	private People people;
//  @RequestMapping(value="/hello", method = RequestMethod.GET)
	@GetMapping(value="/hi")
	private String syaHello(@RequestParam(value="id",required=false,defaultValue="0") int myId) {
		return "Id = " + myId;
	}*/
}
