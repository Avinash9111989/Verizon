package com.infosys.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
    @Bean // htmlReportGenerator bean definition with bean definition
    public ReportGenerator htmlReportGenerator() {
        return new HTMLReportGenerator();
    }
    @Bean // pdfReportGenerator bean definition with bean definition
    public ReportGenerator pdfReportGenerator() {
        return new PDFReportGenerator();
    }
    @Bean // reportService bean definition with bean dependencies through constructor injection
    public ReportService reportService1() {
        ReportService reportService = new ReportService(pdfReportGenerator(), 150);
        return reportService;
    }
    @Bean // reportService bean definition with bean dependencies through setter injection
    public ReportService reportService2() {
        ReportService reportService = new ReportService();
        reportService.setMaster(htmlReportGenerator());
        reportService.setRecordsPerPage(150);
        return reportService;
    }
}
 