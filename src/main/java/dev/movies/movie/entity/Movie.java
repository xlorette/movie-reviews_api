package dev.movies.movie.entity;

import dev.movies.review.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;

    @ElementCollection
    private List<String> genres;
    @ElementCollection
    private List<String> backdrops;

    @OneToMany(mappedBy = "reviews")
    List<Review> reviews;


    public void addReview(Review review){
        reviews.add(review);
    }
}
