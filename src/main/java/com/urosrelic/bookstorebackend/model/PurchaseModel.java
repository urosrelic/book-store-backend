package com.urosrelic.bookstorebackend.model;

import com.urosrelic.bookstorebackend.entity.PurchaseItem;
import com.urosrelic.bookstorebackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseModel {
    private List<PurchaseItem> purchaseItems;
    private User user;
    private Double subtotalAmount;
    private Double tax;
    private Double totalAmount;
}
