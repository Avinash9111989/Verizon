package com.infosys.demo;

import org.springframework.stereotype.Component;

@Component("pdfGenerator")
public class PDFReportGenerator implements ReportGenerator {
	
	public String generateReport(int recordsPerPage) {
		System.out.println("In generate Report method of PDFReportGenerator");
		return "Generated PDF Report with " + recordsPerPage + " records";
	}

}
