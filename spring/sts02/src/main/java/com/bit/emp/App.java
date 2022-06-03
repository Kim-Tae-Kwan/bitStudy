package com.bit.emp;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.emp.model.EmpVo;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		EmpVo bean = (EmpVo) context.getBean("bean");
		
		System.out.println(Arrays.toString(bean.getArr5()));
	}
}
