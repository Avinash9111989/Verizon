package com.infosys.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	@Autowired
	@Qualifier("pdfGenerator")
	private ReportGenerator master;
	@Value("0")
	private int recordsPerPage;

	public void setMaster(ReportGenerator master) {
		this.master = master;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public ReportService() {

	}

	public ReportService(ReportGenerator master, int recordsPerPage) {
		super();
		this.master = master;
		this.recordsPerPage = recordsPerPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public ReportGenerator getMaster() {
		return master;
	}

	public void generateReport() throws ReportGeneratorException {
		try {
			System.out.println(master.generateReport(recordsPerPage));
		} catch (ReportGeneratorException reportGeneratorException) {
			System.out.println(reportGeneratorException.getMessage());
		}
	}
}
