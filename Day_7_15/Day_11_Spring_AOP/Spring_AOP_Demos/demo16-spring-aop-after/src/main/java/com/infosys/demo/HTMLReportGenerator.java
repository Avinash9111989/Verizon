package com.infosys.demo;

import org.springframework.stereotype.Component;

@Component("htmlGenerator")
public class HTMLReportGenerator implements ReportGenerator {
	@Override
	public String generateReport(int recordsPerPage) {
		System.out.println("In generate Report method of HTMLReportGenerator");
		
		return "Generated HTML Report  with " + recordsPerPage + " records";
	}

}