package com.bit.sts05;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.sts05.service.MyModule;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		MyModule module = applicationContext.getBean(MyModule.class);
		
//		module.func01();
		module.func02(1234);
//		System.out.println(module.func03());
//		module.func04();
	}
}