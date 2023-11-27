package com.mmdt.pdfgenerator.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PdfConfig {
    @Value("${pdf.baseDest}")
    private String baseDest;

    @Value("${pdf.headerPngPath}")
    private String headerPngPath;

    @Value("${pdf.footerPngPath}")
    private String footerPngPath;

}

