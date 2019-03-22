package org.chao.web;

import org.chao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncCallController {

	@Autowired
	private AsyncRestTemplate asyncRestTemplate;

	@GetMapping("/call1")
	public String call1() {
		log.info(demo1());
		return "success";
	}

	public String demo1() {
		String url = "http://localhost:8080/student/1";
		log.info("Start");
		ListenableFuture<ResponseEntity<String>> entity = asyncRestTemplate.getForEntity(url, String.class);
		entity.addCallback(new SuccessCallback<ResponseEntity<String>>() {
			@Override
			public void onSuccess(ResponseEntity<String> result) {
				log.info("A");
			}
		}, new FailureCallback() {
			@Override
			public void onFailure(Throwable ex) {
				log.info("B");
			}
		});
		log.info("C");
		return "End";
	}
	
	@GetMapping("/call2")
	public String call2() {
		log.info(demo2());
		return "success";
	}
	
	public String demo2() {
		String url = "http://localhost:8080/student/1";
		log.info("Start");
		ListenableFuture<ResponseEntity<Student>> entity = asyncRestTemplate.getForEntity(url, Student.class);
		entity.addCallback(new SuccessCallback<ResponseEntity<Student>>() {
			@Override
			public void onSuccess(ResponseEntity<Student> result) {
				log.info(result.getBody().getName());
				log.info("A");
			}
		}, new FailureCallback() {
			@Override
			public void onFailure(Throwable ex) {
				log.info("B");
			}
		});
		log.info("C");
		return "End";
	}
}
