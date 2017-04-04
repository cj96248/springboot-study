package com.example.training.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

	private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * com.example.training.controller.MyController.findPeople(..))")
	public void log() {

	}

	@Before("log()")
	public void login() {
		logger.info("First in ...");
	}

	@After("log()")
	public void logout() {
		logger.info("Out ... ");
	}
}
