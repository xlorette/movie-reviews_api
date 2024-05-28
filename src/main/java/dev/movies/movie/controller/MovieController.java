package dev.movies.movie.controller;

import dev.movies.movie.entity.Movie;
import dev.movies.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v0/movies")
@RequiredArgsConstructor
public class MovieController {

   private final MovieService movieService;

  @GetMapping
  public List<Movie> retrieveMovies() {
    return movieService.getAllMovies();
  }

  @GetMapping("/imdbid/{imdbId}")
  public Optional<Movie> getMovieByImdbId(@PathVariable String imdbId) {
    return movieService.getMovieByImdbId(imdbId);
  }
}
