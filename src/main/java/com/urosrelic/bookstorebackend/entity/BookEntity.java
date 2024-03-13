package com.urosrelic.bookstorebackend.entity;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SerializedName("Quote1")
    private String quote1;

    @SerializedName("Quote2")
    private String quote2;

    @SerializedName("Quote3")
    private String quote3;

    private String authors;
    @Column(length = 5000)
    private String description;
    private String edition;
    private String format;

    @SerializedName("genre_list")
    private String genreList;

    private String genres;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("num_pages")
    private Integer numPages;

    private Double rating;

    @SerializedName("rating_count")
    private Integer ratingCount;

    @SerializedName("review_count")
    private Integer reviewCount;

    private String title;
}
