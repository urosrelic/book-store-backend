package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.BookEntity;
import com.urosrelic.bookstorebackend.exceptions.BookNotFoundException;
import com.urosrelic.bookstorebackend.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Page<BookEntity> getBooks(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepo.findAll(pageable);
    }

    public BookEntity getBookData(Integer bookId) throws BookNotFoundException {
        Optional<BookEntity> book = bookRepo.findById(bookId);
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
    }

}
