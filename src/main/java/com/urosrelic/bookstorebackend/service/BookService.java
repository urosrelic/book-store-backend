package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.BookEntity;
import com.urosrelic.bookstorebackend.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void insertBooks(List<BookEntity> books) {
        bookRepo.saveAll(books);
    }

    public List<BookEntity> getBooks() {
        return bookRepo.findAll();
    }
}
