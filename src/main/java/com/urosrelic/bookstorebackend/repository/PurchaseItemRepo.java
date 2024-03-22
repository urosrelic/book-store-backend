package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.Purchase;
import com.urosrelic.bookstorebackend.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseItemRepo extends JpaRepository<PurchaseItem, Long> {
    List<PurchaseItem> findByPurchase(Purchase purchase);
}
