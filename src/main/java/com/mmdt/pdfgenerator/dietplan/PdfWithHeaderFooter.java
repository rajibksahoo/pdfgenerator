package com.mmdt.pdfgenerator.dietplan;

import java.io.File;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.HorizontalAlignment;

public class PdfWithHeaderFooter {
    public static void main(String args[]) {
        try {
            // Specify the base file name and initialize the version counter
            String baseDest = "C:/Users/Admin/Downloads/dietplans_output/sample";
            int versionCounter = 1;

            // Check for existing versions and increment the counter accordingly
            while (new File(baseDest + "_V" + versionCounter + ".pdf").exists()) {
                versionCounter++;
            }

            // Create the destination file with the incremented version number
            String dest = baseDest + "_V" + versionCounter + ".pdf";
            PdfWriter writer = new PdfWriter(dest);

            // Creating a PdfDocument with A4 size and portrait layout
            PdfDocument pdfDoc = new PdfDocument(writer);
            pdfDoc.setDefaultPageSize(PageSize.A4);

            // Creating a Document
            Document document = new Document(pdfDoc);

            // Set margins to zero
            document.setMargins(0, 0, 0, 0);

            // Adding header
            Image headerImage = new Image(ImageDataFactory.create("C:/Users/Admin/Downloads/dietplans_output/source/MMDT_Header.png"));
            headerImage.scaleToFit(pdfDoc.getDefaultPageSize().getWidth(), pdfDoc.getDefaultPageSize().getHeight());
            headerImage.setFixedPosition(0, pdfDoc.getDefaultPageSize().getHeight() - headerImage.getImageScaledHeight());
            document.add(headerImage.setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Adding footer
            Image footerImage = new Image(ImageDataFactory.create("C:/Users/Admin/Downloads/dietplans_output/source/MMDT_Footer.png"));
            footerImage.scaleToFit(pdfDoc.getDefaultPageSize().getWidth(), pdfDoc.getDefaultPageSize().getHeight());
            footerImage.setFixedPosition(0, 0);
            document.add(footerImage.setHorizontalAlignment(HorizontalAlignment.CENTER));

            // Closing the document
            document.close();
            System.out.println("PDF Created: " + dest);
        } catch (Exception e) {
            // Handle the exception
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
