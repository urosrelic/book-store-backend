package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {
}
