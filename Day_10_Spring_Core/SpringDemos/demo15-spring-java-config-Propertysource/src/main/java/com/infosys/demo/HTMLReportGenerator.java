package com.infosys.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component("htmlGenerator")
public class HTMLReportGenerator  implements ReportGenerator{
	
	//The reference variable env can be used to retrieve properties from the application.properties file
	@Autowired
	Environment env;
	
	@Override
	public String generateReport(int recordsPerPage) throws ReportGeneratorException {
		if(recordsPerPage==0)
		{
			throw new ReportGeneratorException(env.getProperty("Insufficient_records"));
		}
		else
			return "Generated HTML Report  with " + recordsPerPage + " records";
	}
}