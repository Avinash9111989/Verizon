package com.infosys.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class Client {
    public static void main(String[] args) {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ReportService srv1 = (ReportService)context.getBean("reportService1");
        srv1.generateReport();        
        ReportService srv2 = (ReportService)context.getBean("reportService2");
        srv2.generateReport();
    	context.close();
    }
}
 

