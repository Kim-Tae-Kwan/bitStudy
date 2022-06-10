package com.bit.sts05.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAfter {
	
	@After("execution(* com.bit.sts05.service.MyModule.*(..))")
	public void afterTargetMethod(JoinPoint thisJoinPoint) {
		Class cls = thisJoinPoint.getSignature().getDeclaringType();
		System.out.println("method after run...");
		System.out.println(cls);
		System.out.println(thisJoinPoint.getSignature().getName());
		System.out.println(Arrays.toString(thisJoinPoint.getArgs()));
	}
	
	//@AfterReturning(pointcut = "execution(* com.bit.sts05.service.MyModule.*(..))", 
	//				returning = "obj")
	public void afterReturningTargetMethod(JoinPoint point, Object obj) {
		System.out.println("after run value : " + obj);
	}
	
	//@AfterThrowing(pointcut = "execution(* com.bit.sts05.service.MyModule.*(..))",
	//				throwing = "ex")
	public void afterThrowingTargetMethod(JoinPoint point, Exception ex) throws Exception {
		System.out.println(ex.getMessage());
	}
}
