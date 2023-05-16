package com.example.jpp.services;

import com.example.jpp.classes.Employee;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;

@Service
public class EmployeeService {
    private static final float CARD_WIDTH = 200;
    private static final float CARD_HEIGHT = 300;

    public void generateIdCards(String csvFilePath) throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            try {
				while ((line = reader.readNext()) != null) {
				    Employee employee = new Employee(line[4], line[0], line[3], line[1], line[2]);
				    generateIdCard(employee);
				}
			} catch (CsvValidationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

    private void generateIdCard(Employee employee) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(CARD_WIDTH, CARD_HEIGHT));
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
        	// Load the image from file
            File imageFile = new File(employee.getImagePath());
            PDImageXObject image = PDImageXObject.createFromFileByContent(imageFile, document);

            // Calculate the position for the image
            float imageX = (CARD_WIDTH - image.getWidth()) / 2;
            float imageY = CARD_HEIGHT - image.getHeight() - 25;

            // Draw the image on the page
            contentStream.drawImage(image, imageX, imageY);

            // Set font and position for the text
            contentStream.beginText();
            float textX = 40; // Horizontal center of the card
            float textY = CARD_HEIGHT - image.getHeight() - 50; // Vertical position below the image

            
            contentStream.newLineAtOffset(textX, textY);
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.showText(employee.getName());
            // Move to the next line
            contentStream.newLineAtOffset(0, -20);
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.showText(employee.getDesignation());
            // Move to the next line
            contentStream.newLineAtOffset(0, -20);
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 8);
            contentStream.showText("Mo: " + employee.getPhone());
            // Move to the next line
            contentStream.newLineAtOffset(0, -20);
            contentStream.newLine();
            contentStream.setFont(PDType1Font.HELVETICA, 8);
            contentStream.showText("Email: " + employee.getEmailId());
            contentStream.endText();
        }

        document.save("id_card_" + employee.getName() + ".pdf");
        document.close();
    }
}
