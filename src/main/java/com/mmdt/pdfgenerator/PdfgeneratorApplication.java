package com.mmdt.pdfgenerator;

import com.mmdt.pdfgenerator.config.NotionProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NotionProperties.class)
public class PdfgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfgeneratorApplication.class, args);
	}

}
