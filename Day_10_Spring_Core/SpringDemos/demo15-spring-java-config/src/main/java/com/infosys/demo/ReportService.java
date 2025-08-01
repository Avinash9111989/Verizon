package com.infosys.demo;
public class ReportService {
    private ReportGenerator master;
    private int recordsPerPage;
    public void setMaster(ReportGenerator master) {
                this.master = master;
        }
        public void setRecordsPerPage(int recordsPerPage) {
                this.recordsPerPage = recordsPerPage;
        }
    public ReportService() {
        System.out.println("constructor");
    }
    public ReportService(ReportGenerator master, int recordsPerPage) {
        super();
        System.out.println("Parameterized Constructor");
        this.master = master;
        this.recordsPerPage = recordsPerPage;
    }
    public int getRecordsPerPage() {
        return recordsPerPage;
    }
    public ReportGenerator getMaster() {
        return master;
    }
    public void generateReport() {
        System.out.println(master.generateReport(recordsPerPage));
    }
}
 

