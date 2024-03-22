package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
}
