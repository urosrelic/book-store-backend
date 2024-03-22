package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.Purchase;
import com.urosrelic.bookstorebackend.exceptions.UserNotFoundException;
import com.urosrelic.bookstorebackend.model.PurchaseModel;
import com.urosrelic.bookstorebackend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/place_order")
    public ResponseEntity<?> placeOrder (@RequestBody PurchaseModel purchaseModel) {
        try {
            Purchase purchase = purchaseService.placeOrder(purchaseModel);
            return new ResponseEntity<>(purchase, HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
