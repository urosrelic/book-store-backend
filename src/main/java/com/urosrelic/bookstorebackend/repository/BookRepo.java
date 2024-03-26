package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByGenreListContaining(String genre);
    Boolean existsByTitle(String title);
}
