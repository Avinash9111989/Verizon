package com.infosys.demo;

import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@AfterThrowing(pointcut="execution(* com.infosys.demo.ReportService.generateReport(..))", throwing="ex")	
	public void logAfterAdvice(JoinPoint joinPoint, Exception ex){
		
		System.out.println("After throwing Advice: " + ex.getMessage());
		
	    //Log Joinpoint signature details
		
		System.out.println("Joinpoint signature :" + joinPoint.getSignature());

		long time = System.currentTimeMillis();
		
        //Log details such as time stamp of report generated
		System.out.println("Report generated at time:" + DateFormat.getDateTimeInstance().format(time));
	}	
	
}
