package com.urosrelic.bookstorebackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseItemId;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    @JsonBackReference  //    Resolves serialization error
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Integer quantity;

    private Double price;
}