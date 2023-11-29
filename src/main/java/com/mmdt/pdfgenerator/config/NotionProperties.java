package com.mmdt.pdfgenerator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "notion")
@Getter
@Setter
public class NotionProperties {

    private final Api api = new Api();
    private final Database database = new Database();

    @Getter
    @Setter
    public static class Api {
        private String key;
    }

    @Getter
    @Setter
    public static class Database {
        private String id;
    }
}

