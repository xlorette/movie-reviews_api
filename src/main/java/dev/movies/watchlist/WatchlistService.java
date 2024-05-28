package dev.movies.watchlist;

import dev.movies.movie.entity.Movie;
import dev.movies.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final MovieService movieService;

    public void addToWatchlist(String movieImdbId, Long userId) {

        Optional<Watchlist> watchlistOpt = watchlistRepository.findByMovieImdbIdAndUserId(movieImdbId, userId);
        if (watchlistOpt.isPresent()) {
            return;
        }
        watchlistRepository.save(Watchlist.builder().userId(userId).movieImdbId(movieImdbId).build());
    }

    public void removeFromWatchList(Long userId, String movieImdbId) {

        Optional<Watchlist> watchlist = watchlistRepository.findByMovieImdbIdAndUserId(movieImdbId, userId);
        watchlist.ifPresent(watchlistRepository::delete);

    }

    public List<Movie> getMovieWatchlist(Long userId) {

        List<Watchlist> userWatchlist = watchlistRepository.findAllByUserId(userId);
        List<String> extractedMovieIds = userWatchlist.stream().map(Watchlist::getMovieImdbId).toList();

        return movieService.getAllMoviesByImdbIds(extractedMovieIds);
    }

}
