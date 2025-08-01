package com.infosys.demo;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	Logger logger=Logger.getLogger(LoggingAspect.class);
	
	@Around("execution(* com.infosys.demo.ReportService.generateReport(..))")	
	public Object logAdvice(ProceedingJoinPoint jp){
		System.out.println("Before: In around advice");
		long start = System.currentTimeMillis();
		Object retVal = null;
		try {
			retVal = jp.proceed();
			
		} catch (Throwable e) {		
			logger.error(e);
		}
		long end = System.currentTimeMillis();
		System.out.println("After: In around advice");
		System.out.println("Report generation took:" + (end-start)+ " milliseconds");
		retVal = "Value returned from advice : " + retVal; // modifying the return value from Joinpoint 
		System.out.println(retVal);
		return (retVal); // returning the modified value to client
	}	
	
	

	
}