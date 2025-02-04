package org.example.Topic2.FollowingOcp;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String directory = "src/main/resources/org/example/Topic2/FollowingOcp/reports/";
        new File(directory).mkdirs(); // Ensure the directory exists

        // Sample sales data
        String salesData = "Laptop,10,800,8000\n" +
                "Smartphone,15,600,9000\n" +
                "Headphones,20,50,1000\n" +
                "Keyboard,30,30,900";


        ReportGenerator reportGenerator = new ReportGenerator();

        // Generate CSV report
        reportGenerator.setStrategy(new CSVReportStrategy());
        reportGenerator.generateReport(salesData, directory + "sales_report.csv");

        // Generate PDF report
        reportGenerator.setStrategy(new PDFReportStrategy());
        reportGenerator.generateReport("Sales Data\n" + salesData, directory + "sales_report.pdf");


        // Generate Excel report
        reportGenerator.setStrategy(new ExcelReportStrategy());
        reportGenerator.generateReport(salesData, directory + "sales_report.xlsx");

    }
}
