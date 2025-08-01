package com.infosys.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ReportService {
	@Autowired
	private ReportGenerator master;
	
	@Value("100")
	private int recordsPerPage;
	
	public ReportService() {
		System.out.println("default constructor");
	}
	
	public ReportService(ReportGenerator master) {
		System.out.println("constructor");
		this.master = master;
	}
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		System.out.println("setRecordsPerPage");
		this.recordsPerPage = recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

		
	public void setMaster(ReportGenerator master) {
		System.out.println("setMaster");

		this.master = master;
	}

	public void generateReport() {
		System.out.println(master.generateReport(recordsPerPage));
	}
}
