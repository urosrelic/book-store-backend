package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByGenreListContaining(String genre);
}
