package dev.movies.movie.service;

import dev.movies.movie.entity.Movie;
import dev.movies.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

  private final MovieRepository movieRepository;


  public Movie getMovieByImdbId(String imdbId) {

    Optional<Movie> movieByImdbIdOpt = movieRepository.findMovieByImdbId(imdbId);
    if(movieByImdbIdOpt.isEmpty())
    {
      throw new RuntimeException(); //TODO to be replaced with true exceptioon
    }
    return movieByImdbIdOpt.get();

  }

  public void save(Movie movie) {

    movieRepository.save(movie);
  }

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }
}
