package com.infosys.demo;



public class PDFReportGenerator implements ReportGenerator {
	@Override
	public String generateReport(int recordsPerPage) {
		
		return "Generated PDF Report with " + recordsPerPage + "records";
	}
}
