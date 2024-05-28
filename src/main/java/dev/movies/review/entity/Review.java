package dev.movies.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.movies.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "reviews")
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String body;

    @ManyToOne
    @JsonIgnore
    private Movie movie;

}

