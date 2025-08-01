package com.infosys.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class ReportService {
	
	private ReportGenerator master;	
	
	private int recordsPerPage;
	
	public ReportService() {
		System.out.println("default constructor");
	}	
	
	@Autowired	
	public ReportService(int recordsPerPage,ReportGenerator master) {
		System.out.println("Parameterized Constructor");		
		this.recordsPerPage = recordsPerPage;
		this.master = master;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		System.out.println("Setter method of RecordsPerPage property");
		this.recordsPerPage = recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

	
	public void setMaster(ReportGenerator master) {
		System.out.println("Setter method of master property");
		this.master = master;
	}

	public void generateReport() {
		System.out.println(master.generateReport(recordsPerPage));
	}
}
