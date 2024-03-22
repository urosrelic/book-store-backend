package com.urosrelic.bookstorebackend.service;

import com.urosrelic.bookstorebackend.entity.Purchase;
import com.urosrelic.bookstorebackend.entity.PurchaseItem;
import com.urosrelic.bookstorebackend.entity.User;
import com.urosrelic.bookstorebackend.exceptions.UserNotFoundException;
import com.urosrelic.bookstorebackend.model.PurchaseModel;
import com.urosrelic.bookstorebackend.repository.PurchaseItemRepo;
import com.urosrelic.bookstorebackend.repository.PurchaseRepo;
import com.urosrelic.bookstorebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepo purchaseRepo;
    private final PurchaseItemRepo purchaseItemRepo;
    private final UserRepo userRepo;

    @Autowired
    public PurchaseService(PurchaseRepo purchaseRepo, PurchaseItemRepo purchaseItemRepo, UserRepo userRepo) {
        this.purchaseRepo = purchaseRepo;
        this.purchaseItemRepo = purchaseItemRepo;
        this.userRepo = userRepo;
    }

    public Purchase placeOrder(PurchaseModel purchaseModel) throws UserNotFoundException {
        User user = purchaseModel.getUser();
        if(user == null) {
           throw new UserNotFoundException();
        }

        Purchase purchase = new Purchase();

        List<PurchaseItem> purchaseItems = purchaseModel.getPurchaseItems();

        for(PurchaseItem item : purchaseItems) {
            item.setPurchase(purchase);
        }

        purchase.setPurchaseItems(purchaseItems);
        purchase.setUser(user);
        purchase.setSubtotalAmount(purchaseModel.getSubtotalAmount());
        purchase.setTax(purchaseModel.getTax());
        purchase.setTotalAmount(purchaseModel.getTotalAmount());

        return purchaseRepo.save(purchase);
    }
}
