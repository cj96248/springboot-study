package com.example.training.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
/**
 * Spring boot 启动监听
 * @author Administrator
 *
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

	private Logger log = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);
	@Override
	public void onApplicationEvent(ApplicationStartedEvent arg0) {
		SpringApplication application = arg0.getSpringApplication();
		application.setHeadless(false);
		log.info("-------Started evnet listener------");
	}

}
