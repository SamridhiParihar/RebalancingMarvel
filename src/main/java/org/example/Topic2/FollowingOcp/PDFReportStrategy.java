package org.example.Topic2.FollowingOcp;

public class PDFReportStrategy implements ReportStrategy{

    @Override
    public void generate(String data , String path) {
        System.out.println("Generating PDF report with data: " + data);
        // PDF-specific logic
        ReportService.generatePdfReport("Sales Data\n" + data, path);
    }

}
