package org.example.Topic2.FollowingOcp;

public class CSVReportStrategy implements ReportStrategy{
    @Override
    public void generate(String data , String path) {
        System.out.println("Generating CSV report with data: " + data);
        // CSV-specific logic
        ReportService.generateCsvReport(data,path);
    }
}
