package com.urosrelic.bookstorebackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
