package com.bit.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.spring.service.UserService;

public class App {
	static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		UserService service = context.getBean("proxy", UserService.class);
		service.setMsg("수정");
		service.printMsg();
		
		service.printSu();
	}

}
