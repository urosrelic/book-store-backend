package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.TransactionEntity;
import com.urosrelic.bookstorebackend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/insertData")
    public ResponseEntity<?> insertData(@RequestBody TransactionEntity transaction) {
        TransactionEntity transactionEntity = transactionService.insertData(transaction);
        if(transactionEntity != null) {
            return new ResponseEntity<>(transactionEntity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
