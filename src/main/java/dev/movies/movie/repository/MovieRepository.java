package dev.movies.movie.repository;

import dev.movies.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByImdbId(String imdbId);
    List<Movie> findAllByImdbIdIn(List<String> imdbIds);
}
