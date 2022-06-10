package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Aspect
public class UserBefore {
	
	//@Before("execution(* com.bit.sts05.service.MyModule.*(..))")
	public void beforeTargetMethod(JoinPoint thisJoinPoint) {
		System.out.println("method before run...");
		System.out.println(thisJoinPoint);
	}
}
