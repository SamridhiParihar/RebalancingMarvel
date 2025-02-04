package org.example.Topic2.NotFollowingOcp;

public class ReportGenerator {
    public void generateReport(String reportType, String data) {
        if (reportType.equals("PDF")) {
            System.out.println("Generating PDF report with data: " + data);
            // Complex PDF generation logic

        } else if (reportType.equals("CSV")) {
            System.out.println("Generating CSV report with data: " + data);
            // Complex CSV generation logic

        } else {
            throw new IllegalArgumentException("Invalid report type");
        }
    }
}
