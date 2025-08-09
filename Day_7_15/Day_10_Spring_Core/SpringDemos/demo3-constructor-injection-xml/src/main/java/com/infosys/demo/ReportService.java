package com.infosys.demo;

public class ReportService {

	private ReportGenerator master;
	private int recordsPerPage;
	public ReportService(ReportGenerator master, int recordsPerPage) {
		System.out.println("Parameterized Constructor");
		this.master = master;
		this.recordsPerPage = recordsPerPage;
	}

	
	public ReportService() {
		
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

	public void setMaster(ReportGenerator master) {
		this.master = master;
	}

	public void generateReport() {
		System.out.println(master.generateReport(recordsPerPage));
	}
}
