package dev.movies.review.controller;

import dev.movies.review.entity.Review;
import dev.movies.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v0/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private  final ReviewService reviewService;
    @PostMapping(value = "/addreview/imdbid/{imdbId}")
    public Review addReview(@PathVariable String imdbId, @RequestBody Review review){

        return reviewService.addReview(imdbId, review);
    }

}
