package org.example.Topic2.FollowingOcp;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class ReportService {

    // Generate PDF report
    public static void generatePdfReport(String data, String filePath) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 750);

            // Split data into lines and write each line separately
            String[] lines = data.split("\n");
            for (String line : lines) {
                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -20); // Move cursor down for the next line
            }

            contentStream.endText();
            contentStream.close();

            document.save(filePath);
            System.out.println("PDF Report generated: " + filePath);
        } catch (IOException e) {
            System.out.println("Error generating PDF report: " + e.getMessage());
        }
    }


    // Generate Excel report
    public static void generateExcelReport(String data, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Report");

            // Adding headers
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Product Name");
            header.createCell(1).setCellValue("Quantity Sold");
            header.createCell(2).setCellValue("Price");
            header.createCell(3).setCellValue("Total Sales");

            // Adding rows of data
            String[] lines = data.split("\n");
            int rowNum = 1;  // Start from the second row
            for (String line : lines) {
                Row row = sheet.createRow(rowNum++);
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    row.createCell(i).setCellValue(values[i]);
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
            System.out.println("Excel Report generated: " + filePath);
        } catch (IOException e) {
            System.out.println("Error generating Excel report: " + e.getMessage());
        }
    }

    // Generate CSV report
    public static void generateCsvReport(String data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Product Name,Quantity Sold,Price,Total Sales\n");

            // Adding rows of data
            String[] lines = data.split("\n");
            for (String line : lines) {
                writer.append(line).append("\n");
            }
            System.out.println("CSV Report generated: " + filePath);
        } catch (IOException e) {
            System.out.println("Error generating CSV report: " + e.getMessage());
        }
    }
}
