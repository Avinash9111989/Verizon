package com.infosys.demo;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
	AbstractApplicationContext	context = new ClassPathXmlApplicationContext("config.xml");
		ReportService srv1 = (ReportService)context.getBean("reportService");
		ReportService srv2 = (ReportService)context.getBean("reportService");
		System.out.println("hash code of srv1:" + srv1.hashCode());
		System.out.println("hash code of srv2:" +srv2.hashCode());
		if(srv1==srv2){
			System.out.println("Same instance");
		}
		else
			System.out.println("Different instance");
		context.close();
	}

}
