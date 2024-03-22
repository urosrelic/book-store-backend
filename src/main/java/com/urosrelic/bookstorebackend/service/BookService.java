package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.Book;
import com.urosrelic.bookstorebackend.exceptions.BookNotFoundException;
import com.urosrelic.bookstorebackend.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void insertBooks(List<Book> books) {
        bookRepo.saveAll(books);
    }

    public Page<Book> getBooks(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepo.findAll(pageable);
    }

    public List<Book> getFilteredBooksByGenre(String genre) {
        return bookRepo.findByGenreListContaining(genre);
    }

    public Book getBookData(Long bookId) throws BookNotFoundException {
        Optional<Book> book = bookRepo.findById(bookId);
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
    }

    public Set<String> getGenres() {
        List<Book> books = bookRepo.findAll();
        Set<String> genresList = new HashSet<>();
        for(Book book : books) {
            String[] genres = book.getGenreList().split(",");
            genresList.addAll(Arrays.asList(genres));
        }
        return genresList;
    }

}
