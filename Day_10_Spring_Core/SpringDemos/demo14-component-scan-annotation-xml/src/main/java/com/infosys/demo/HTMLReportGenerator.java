package com.infosys.demo;
import org.springframework.stereotype.Component;

@Component(value="htmlGenerator")
public class HTMLReportGenerator  implements ReportGenerator{

	@Override
	public String generateReport(int recordsPerPage) {
		
		return "Generated HTML Report  with " + recordsPerPage + " records";
	}
}