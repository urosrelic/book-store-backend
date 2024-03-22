package com.urosrelic.bookstorebackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    @JsonManagedReference     //    Resolves serialization error
    private List<PurchaseItem> purchaseItems;

    private Double subtotalAmount;
    private Double tax;
    private Double totalAmount;

    private Timestamp date;
}
