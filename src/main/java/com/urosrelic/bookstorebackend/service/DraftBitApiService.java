package com.urosrelic.bookstorebackend.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.urosrelic.bookstorebackend.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class DraftBitApiService {
    private final String apiUrl = "https://example-data.draftbit.com/books?_limit=50";
    private final RestTemplate restTemplate;
    private final Gson gson;

    @Autowired
    public DraftBitApiService(RestTemplate restTemplate, Gson gson) {
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    public List<Book> getDataFromApi() {
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        // Define the type of the expected list using TypeToken
        Type listType = new TypeToken<List<Book>>(){}.getType();

        // Deserialize JSON array into a list of BookEntity objects
        return gson.fromJson(jsonResponse, listType);
    }
}
