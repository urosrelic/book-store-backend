package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<TransactionEntity, Long> {
}
