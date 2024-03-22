package com.urosrelic.bookstorebackend.repository;

import com.urosrelic.bookstorebackend.entity.Purchase;
import com.urosrelic.bookstorebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
    List<Purchase> findByUser(User user);
}
