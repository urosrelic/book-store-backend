package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.TransactionEntity;
import com.urosrelic.bookstorebackend.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TransactionService {
    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public TransactionEntity insertData(TransactionEntity transactionEntity) {
        return transactionRepo.save(transactionEntity);
    }
}
