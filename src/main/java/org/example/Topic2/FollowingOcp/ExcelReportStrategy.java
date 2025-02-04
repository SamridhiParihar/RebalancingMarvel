package org.example.Topic2.FollowingOcp;

public class ExcelReportStrategy implements ReportStrategy{
    @Override
    public void generate(String data, String path) {
        System.out.println("Generating PDF report with data: " + data);
        // PDF-specific logic
        ReportService.generateExcelReport(data, path);
    }
}
