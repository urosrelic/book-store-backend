package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.BookEntity;
import com.urosrelic.bookstorebackend.exceptions.BookNotFoundException;
import com.urosrelic.bookstorebackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Page<BookEntity> getBooks(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        return bookService.getBooks(page, size);
    }

    @GetMapping("/book/{book_id}")
    public ResponseEntity<?> getBookData(@PathVariable("book_id") Integer bookId) {
        try {
            BookEntity bookEntity = bookService.getBookData(bookId);
            return ResponseEntity.ok(bookEntity);
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/genres")
    public Set<String> getGenres() {
        return bookService.getGenres();
    }
}
