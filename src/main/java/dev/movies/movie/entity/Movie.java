package dev.movies.movie.entity;

import dev.movies.review.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
@Entity
@Slf4j
public class Movie {


    @Id
    private String imdbId;

    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;

    @ElementCollection
    private List<String> genres;
    @ElementCollection
    private List<String> backdrops;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;


    public void addReview(Review review) {
        log.warn("added :{} ", review);
        reviews.add(review);
        log.warn("list after adding : {}", review);
    }
}
