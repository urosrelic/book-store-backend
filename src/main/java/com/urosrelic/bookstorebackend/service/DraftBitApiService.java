package com.urosrelic.bookstorebackend.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.urosrelic.bookstorebackend.entity.BookEntity;
import com.urosrelic.bookstorebackend.repository.BookRepo;
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
    private final BookRepo bookRepo;

    @Autowired
    public DraftBitApiService(RestTemplate restTemplate, Gson gson, BookRepo bookRepo) {
        this.restTemplate = restTemplate;
        this.gson = gson;
        this.bookRepo = bookRepo;
    }

    public List<BookEntity> getDataFromApi() {
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);

        // Define the type of the expected list using TypeToken
        Type listType = new TypeToken<List<BookEntity>>(){}.getType();

        // Deserialize JSON array into a list of BookEntity objects
        return gson.fromJson(jsonResponse, listType);
    }
}
