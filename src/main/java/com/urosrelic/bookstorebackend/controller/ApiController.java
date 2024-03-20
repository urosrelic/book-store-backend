package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.BookEntity;
import com.urosrelic.bookstorebackend.service.BookService;
import com.urosrelic.bookstorebackend.service.DraftBitApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final DraftBitApiService draftBitApiService;
    private final BookService bookService;

    @Autowired
    public ApiController(DraftBitApiService draftBitApiService, BookService bookService) {
        this.draftBitApiService = draftBitApiService;
        this.bookService = bookService;
    }

    @GetMapping("/getData")
    public List<BookEntity> getDataFromApi() {
        return draftBitApiService.getDataFromApi();
    }

    @PostMapping("/insertData")
    public ResponseEntity<Void> insertDataFromApi() {
        List<BookEntity> fetchedData = draftBitApiService.getDataFromApi();
        List<BookEntity> booksWithUpdatedPrices = new ArrayList<>();
        for (BookEntity book : fetchedData) {
            book.setPrice(book.generateRandomPrice());
            booksWithUpdatedPrices.add(book);
        }
        bookService.insertBooks(booksWithUpdatedPrices);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
