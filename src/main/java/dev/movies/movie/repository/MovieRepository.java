package dev.movies.movie.repository;

import dev.movies.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long > {
  Optional<Movie> findMovieByImdbId(String imdbId);
}
