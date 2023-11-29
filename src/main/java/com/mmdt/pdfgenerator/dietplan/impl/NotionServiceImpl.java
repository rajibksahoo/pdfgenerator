package com.mmdt.pdfgenerator.dietplan.impl;

import com.mmdt.pdfgenerator.config.NotionProperties;
import com.mmdt.pdfgenerator.data.MealPOJO;
import com.mmdt.pdfgenerator.data.NotionResponse;
import com.mmdt.pdfgenerator.dietplan.NotionService;
import com.mmdt.pdfgenerator.mapper.NotionResponseMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

@Service
public class NotionServiceImpl implements NotionService {

    @Value("${notion.api.key}")
    private String notionApiKey;

    @Value("${notion.database.id}")
    private String notionDatabaseId;

    private static final String NOTION_API_URL = "https://api.notion.com/v1/databases/{databaseId}/query";

    private final RestTemplate restTemplate;

    public NotionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<MealPOJO> getAllMeals() {
        //test
        notionApiKey = "secret_AJjzU3jJxomUWWcLgs0eLwWIHLJb12frIBobq0xKwi1";
        notionDatabaseId = "5eee4c003c4d4fb1b774454e966011c2";
        //test

        String url = NOTION_API_URL.replace("{databaseId}", notionDatabaseId);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + notionApiKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Notion-Version", "2022-06-28");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<NotionResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                NotionResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // Parse the response and map it to a list of MealPOJO objects
            NotionResponse responseBody = responseEntity.getBody();

            return NotionResponseMapper.mapToListOfMealPOJO(responseBody);
        } else {
            // Handle error scenario
            System.out.println("Error response: " + responseEntity.getBody());
            return Collections.emptyList();
        }


        //return null; // Replace with actual implementation
    }
}

