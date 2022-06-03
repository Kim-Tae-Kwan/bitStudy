package com.bit.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class AroundMethod implements MethodInterceptor{
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.debug("Around... before");
		Object object = null;
		try {
			object = invocation.proceed();
		} catch (Exception e) {
		}
		
		log.debug("Around... after");
		return object;
	}

}
