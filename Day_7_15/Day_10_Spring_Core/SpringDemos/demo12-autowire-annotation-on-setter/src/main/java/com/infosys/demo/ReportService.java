package com.infosys.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ReportService {
	
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
		System.out.println("Setter Method of RecordsPerPage Property");
		this.recordsPerPage = recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

	@Autowired	
	public void setMaster(ReportGenerator master) {
		System.out.println("Setter Method of master Property");
		this.master = master;
	}

	public void generateReport() {
		System.out.println(master.generateReport(recordsPerPage));
	}
}
