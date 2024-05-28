package dev.movies.review.controller;

import dev.movies.review.entity.Review;
import dev.movies.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v0/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(value = "/addreview/imdbid/{imdbId}/username/{username}")
    public Review addReview(@PathVariable String imdbId, @PathVariable String username, @RequestBody Review review) {

        return reviewService.addReview(imdbId, review, username);
    }

}
