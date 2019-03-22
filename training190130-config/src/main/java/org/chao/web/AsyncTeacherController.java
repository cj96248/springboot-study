package org.chao.web;

import org.chao.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncTeacherController {

	@Autowired
	private AsyncRestTemplate asyncRestTemplate;
	
	@GetMapping("/call3")
	public String call3() {
		log.info(demo3());
		return "success";
	}
	
	public String demo3() {
		String url = "http://localhost:8080/teacher/1";
		log.info("Start");
		ListenableFuture<ResponseEntity<Teacher>> entity = asyncRestTemplate.getForEntity(url, Teacher.class);
		entity.addCallback(result -> log.info(result.getBody().getName()),(e) -> log.error(e.getMessage()));
		log.info("C");
		return "End";
	}
	
	@GetMapping("/call4")
	public String call4() {
		log.info(demo4());
		return "success";
	}
	
	public String demo4() {
		String url = "http://localhost:8080/save/teacher";
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
		Teacher teacher = new Teacher().setId(4).setName("Kelly");
		ListenableFuture<ResponseEntity<Teacher>> entity = asyncRestTemplate.postForEntity(url, httpEntity, Teacher.class, teacher);
		entity.addCallback(result -> log.info(result.getBody().getName()),(e) -> log.error(e.getMessage()));
		log.info("C");
		return "End";
	}
}
