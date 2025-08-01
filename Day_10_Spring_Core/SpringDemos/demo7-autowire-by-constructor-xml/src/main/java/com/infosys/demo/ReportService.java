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
		System.out.println("Default Constructor");

	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		System.out.println("Setter Method of recordsPerPage property");
		this.recordsPerPage = recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

	public void setMaster(ReportGenerator master) {
		System.out.println("Setter Method of master property");
		this.master = master;
	}

	public void generateReport() {
		System.out.println(master.generateReport(recordsPerPage));
	}
}
