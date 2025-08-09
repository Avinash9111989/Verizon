package com.infosys.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class Client {
    public static void main(String[] args) throws ReportGeneratorException {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ReportService srv1 = (ReportService)context.getBean("reportService");
        srv1.generateReport();        
        context.close();
    }
}
 

