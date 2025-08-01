package com.infosys.demo;

public class ReportService {
	
	ReportGenerator master = new HTMLReportGenerator();
	int recordsPerPage = 100;
	public void generateReport() {
		System.out.println(master.generateReport(recordsPerPage));
	}
}
