package com.infosys.demo;

import org.springframework.stereotype.Component;

@Component(value="pdfGenerator")
public class PDFReportGenerator implements ReportGenerator {
        @Override
        public String generateReport(int recordsPerPage) {
                return "Generated PDF Report with " + recordsPerPage + " records";
        }
}
 