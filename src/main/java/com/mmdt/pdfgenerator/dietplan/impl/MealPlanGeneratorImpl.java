package com.mmdt.pdfgenerator.dietplan.impl;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.TextAlignment;
import com.mmdt.pdfgenerator.config.PdfConfig;
import com.mmdt.pdfgenerator.dietplan.MealPlanGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.net.MalformedURLException;

@Slf4j
@Service
public class MealPlanGeneratorImpl implements MealPlanGenerator {

    private final PdfConfig pdfConfig;

    @Autowired
    public MealPlanGeneratorImpl(PdfConfig pdfConfig) {
        this.pdfConfig = pdfConfig;
    }

    @Autowired
    private NotionServiceImpl notionService;

    @Override
    public String generateMealPlanPDF(String fileName) {
        String dest = getVersionedFileName(pdfConfig.getBaseDest(), fileName);

        try (PdfWriter writer = new PdfWriter(dest);
             PdfDocument pdfDoc = new PdfDocument(writer);
             Document document = new Document(pdfDoc)) {

            pdfDoc.setDefaultPageSize(PageSize.A4);
            document.setMargins(0, 0, 0, 0);

            // Adding default header and footer for the first page
            addDefaultHeaderAndFooter(document);

            // Adding table area for the first page
            addTableArea(document);

            // Generate the second page with the same header and footer
            addNewPageWithHeaderAndFooter(document);

            log.info("PDF Created: " + dest);
            return dest;
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    private String getVersionedFileName(String baseDest, String fileName) {
        int versionCounter = 1;
        String dest = baseDest + fileName + "_V" + versionCounter + ".pdf";

        while (new File(dest).exists()) {
            versionCounter++;
            dest = baseDest + fileName + "_V" + versionCounter + ".pdf";
        }

        return dest;
    }

    private static void addImageToDocument(Document document, String imagePath, boolean isHeader) throws MalformedURLException {
        Image image = new Image(ImageDataFactory.create(imagePath));
        image.scaleToFit(document.getPdfDocument().getDefaultPageSize().getWidth(),
                document.getPdfDocument().getDefaultPageSize().getHeight());
        float yPosition = isHeader ? document.getPdfDocument().getDefaultPageSize().getHeight() - image.getImageScaledHeight() : 0;
        image.setFixedPosition(0, yPosition);
        document.add(image.setHorizontalAlignment(HorizontalAlignment.CENTER));
    }

    private static void addTableArea(Document document) {
        // Adding space for the table
        document.add(new com.itextpdf.layout.element.Paragraph("\n\n\n\n\n\n")); // You can adjust the space as needed

        // Adding table to the document
        addTableToDocument(document);
    }

    private static void addTableToDocument(Document document) {
        // Adding static table with specified column names
        Table table = new Table(7); // 7 columns
        table.setWidth(UnitValue.createPercentValue(80)); // Set width to 80% of the page
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // Adding column names
        table.addCell("Meal Name");
        table.addCell("Ingredients");
        table.addCell("Protein");
        table.addCell("Carbs");
        table.addCell("Fat");
        table.addCell("Fiber");
        table.addCell("Calories");




        // Adding table to the document
        document.add(table.setTextAlignment(TextAlignment.CENTER));
    }

    private void handleException(Exception e) {
        log.error("An error occurred: " + e.getMessage());
        e.printStackTrace();
    }

    private  void addDefaultHeaderAndFooter(Document document) throws MalformedURLException {
        // Adding default header
        addImageToDocument(document, pdfConfig.getHeaderPngPath(), true);

        // Adding default footer
        addImageToDocument(document, pdfConfig.getFooterPngPath(), false);
    }

    private void addNewPageWithHeaderAndFooter(Document document) throws MalformedURLException {
        document.add(new AreaBreak());

        // Adding header for the new page
        addImageToDocument(document, pdfConfig.getHeaderPngPath(), true);

        // Adding table area for the new page
        addTableArea(document);

        // Adding footer for the new page
        addImageToDocument(document, pdfConfig.getFooterPngPath(), false);
    }
}

