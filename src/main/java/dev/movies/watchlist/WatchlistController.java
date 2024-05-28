package dev.movies.watchlist;

import dev.movies.movie.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v0/watchlist")
public class WatchlistController {

    private final WatchlistService watchlistService;

    @GetMapping(value = "/userid/{userId}")
    public List<Movie> getWatchlist(@PathVariable Long userId) {
        return watchlistService.getMovieWatchlist(userId);
    }

    @DeleteMapping(value = "/add/userid/{userId}/movieimdbid/{movieImdbId}")
    public void removeFromWatchlist(@PathVariable Long userId, @PathVariable String movieImdbId) {
        watchlistService.removeFromWatchList(userId, movieImdbId);
    }

    @PostMapping(value = "/add/userid/{userId}/movieimdbid/{movieImdbId}")
    public void addToWatchlist(@PathVariable Long userId, @PathVariable String movieImdbId) {
        watchlistService.addToWatchlist(movieImdbId, userId);
    }
}
