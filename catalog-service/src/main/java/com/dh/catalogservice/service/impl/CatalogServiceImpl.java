package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.SerieRepository;
import com.dh.catalogservice.service.CatalogService;
import com.dh.catalogservice.service.MovieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class CatalogServiceImpl implements CatalogService {

    private IMovieClient iMovieClient;
    private ISerieClient iSerieClient;
    private MovieService movieService;
    private SerieRepository serieRepository;

    public CatalogServiceImpl(IMovieClient iMovieClient, ISerieClient iSerieClient, MovieService movieService, SerieRepository serieRepository) {
        this.iMovieClient = iMovieClient;
        this.iSerieClient = iSerieClient;
        this.movieService = movieService;
        this.serieRepository = serieRepository;
    }

    // TODO: cambiar el nombre "movies" a "catalog" en las configuraciones
    //  del circuit breaker en catalog-service
    @CircuitBreaker(name="movies", fallbackMethod = "getCatalogFallbackMethod")
    @Retry(name="movies")
    @Override
    public Genre findByGenre(String genre) throws RuntimeException{

//        log.info("Response received from port: {}", list.getHeaders().get("port"));

        return new Genre(movieService.getMoviesByGenre(genre, false), serieRepository.getSeriesByGenre(genre));
    }

    // método fallback
    public Genre getCatalogFallbackMethod(String genre, Exception ex) {
        Genre resultsByGenre = new Genre();

        ResponseEntity<List<Movie>> movieList = iMovieClient.getMovieByGenre(genre);
        ResponseEntity<List<Serie>> serieList = iSerieClient.getSerieByGenre(genre);

        resultsByGenre.setMovies(movieList.getBody());
        resultsByGenre.setSeries(serieList.getBody());

        return resultsByGenre;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie savedMovie;
        ResponseEntity<Movie> movieResponseEntity = iMovieClient.saveMovie(movie);
        savedMovie = movieResponseEntity.getBody();
        return savedMovie;
    }

    // saveSerie
    @Override
    public Serie create(Serie serie) {
        Serie newSerie;
        ResponseEntity<Serie> serieSaved = iSerieClient.create(serie);
        newSerie = serieSaved.getBody();
        return newSerie;
    }

}
