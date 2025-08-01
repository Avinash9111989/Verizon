package com.infosys.demo;

public class ReportService {

	private ReportGenerator master;
	private int recordsPerPage;
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		System.out.println("Setter Method of RecordsPerPage Property");
		this.recordsPerPage = recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

	public void setMaster(ReportGenerator master) {
		System.out.println("Setter Method of master Property");
		this.master = master;
	}

	public void generateReport() {
		System.out.println(master.generateReport(recordsPerPage));
	}
}
