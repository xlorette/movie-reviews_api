package dev.movies.review.controller;

import dev.movies.review.entity.Review;
import dev.movies.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(value = "/addreview/imdbid/{imdbId}/userid/{userId}")
    public Review addReview(@PathVariable String imdbId, @PathVariable Long userId, @RequestBody Review review) {

        return reviewService.addReview(imdbId, review, userId);
    }

}
