package com.infosys.demo;

import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@AfterReturning("execution(* com.infosys.demo.ReportService.generateReport(..))")	
	public int logAfterAdvice(JoinPoint joinPoint){
		
	    //Log Joinpoint signature details
		
		System.out.println("Joinpoint signature :" + joinPoint.getSignature());

		long time = System.currentTimeMillis();
		
        //Log details such as time stamp of report generated
		System.out.println("Report generated at time:" + DateFormat.getDateTimeInstance().format(time));
        return 1;
	}	
	
}
