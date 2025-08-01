package com.infosys.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.service.ReportService;
/**
 * The Class Client.
 */
public class Client{
   
    public static void main(String[] args) {
        
        //ApplicationContext container is instantiated by loading the configuration from config.xml available in application classpath
       AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        // Accessing bean with id “reportService" and typecast from Object type to ReportService type
        ReportService reportService = (ReportService) context.getBean("reportService");
         // Invoking display method of ReportService to display greeting on console
       reportService.display();
       context.close();
    }

}