package dev.movies.review.service;

import dev.movies.exceptions.EntityNotFoundException;
import dev.movies.movie.entity.Movie;
import dev.movies.movie.service.MovieService;
import dev.movies.review.entity.Review;
import dev.movies.review.repository.ReviewRepository;
import dev.movies.user.entity.User;
import dev.movies.user.service.UserService;
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

  private final UserService userService;

  public Review addReview(String imdbId, Review review, Long userId) {

    Optional<Movie> movieOpt = movieService.getMovieByImdbId(imdbId);
    if (movieOpt.isEmpty()) {
      throw new EntityNotFoundException("Movie not found!");
    }

    Optional<User> userOpt = userService.findUserById(userId);

    if (userOpt.isEmpty()) {
      throw new EntityNotFoundException("User not found!");
    }

    review.setUsername(userOpt.get().getUsername());
    review.setMovie(movieOpt.get());

    return reviewRepository.save(review);
  }
}
