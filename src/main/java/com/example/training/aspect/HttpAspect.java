package com.example.training.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {

	private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//	@Pointcut("execution(public * com.example.training.controller.MyController.findPeople(..))")
	@Pointcut("execution(public * com.example.training.controller.MyController.*(..))")
	public void log() {

	}

	@Before("log()")
	public void login(JoinPoint point) {
		logger.info("First in ...");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}", request.getRequestURL());
		//method
		logger.info("method={}", request.getMethod());
		//ip
		logger.info("ip={}", request.getRemoteAddr());
		//class method
		logger.info("class-method={}",point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
		//args
		logger.info("arguments={}", point.getArgs());
	}

	@After("log()")
	public void logout() {
		logger.info("Finally out ... ");
	}
	
	@AfterReturning(pointcut="log()",returning="object")
	public void afterReturn(Object object){
		logger.info("response={}", object);
	}
}
