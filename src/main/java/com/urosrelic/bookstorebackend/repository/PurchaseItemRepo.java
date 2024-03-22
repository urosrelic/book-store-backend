package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepo extends JpaRepository<PurchaseItem, Long> {
}
