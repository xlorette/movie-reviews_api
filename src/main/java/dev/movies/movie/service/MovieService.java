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


    public Optional<Movie> getMovieByImdbId(String imdbId) {

        return movieRepository.findMovieByImdbId(imdbId);

    }

    public void save(Movie movie) {

        movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
