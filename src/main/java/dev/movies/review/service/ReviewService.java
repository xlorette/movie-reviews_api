package dev.movies.review.service;

import dev.movies.movie.entity.Movie;
import dev.movies.movie.service.MovieService;
import dev.movies.review.entity.Review;
import dev.movies.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieService movieService;


    public Review addReview(String imdbId, Review review) {
        Optional<Movie> movieOpt = movieService.getMovieByImdbId(imdbId);

        if (movieOpt.isEmpty()) {
            throw new RuntimeException();
            //throw error sa stie clientu ca nu exista
        }
        Movie movie = movieOpt.get();

        movie.addReview(review);
        movieService.save(movie);

        return reviewRepository.save(review);
    }
}
