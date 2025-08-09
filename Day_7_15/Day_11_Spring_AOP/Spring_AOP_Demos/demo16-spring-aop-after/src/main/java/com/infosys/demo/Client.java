package com.infosys.demo;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	static Logger logger=Logger.getLogger(Client.class);
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ReportService srv = (ReportService) context.getBean("reportService");
		try {
			srv.generateReport();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			logger.error(exp.getMessage());
		}
		context.close();
	}
}
