package com.urosrelic.bookstorebackend.controller;

import com.urosrelic.bookstorebackend.entity.Purchase;
import com.urosrelic.bookstorebackend.exceptions.UserNotFoundException;
import com.urosrelic.bookstorebackend.model.PurchaseModel;
import com.urosrelic.bookstorebackend.model.UserModel;
import com.urosrelic.bookstorebackend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/place_purchase")
    public ResponseEntity<?> placeOrder (@RequestBody PurchaseModel purchaseModel) {
        try {
            Purchase purchase = purchaseService.placeOrder(purchaseModel);
            return new ResponseEntity<>(purchase, HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get_purchases")
    public ResponseEntity<?> getPurchases(@RequestParam Long userId) {
        try {
            List<Purchase> purchases = purchaseService.getPurchases(userId);
            if(purchases != null) {
                return new ResponseEntity<>(purchases, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
