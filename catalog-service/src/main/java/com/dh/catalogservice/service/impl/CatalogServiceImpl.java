package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class CatalogServiceImpl implements CatalogService {

    private IMovieClient iMovieClient;

    public CatalogServiceImpl(IMovieClient iMovieClient) {
        this.iMovieClient = iMovieClient;
    }

    @Override
    public Genre findByGenre(String genre)  {
//        return new Genre(iMovieClient.getMovieByGenre(genre));
        Genre resultsByGenre = new Genre();
        ResponseEntity<List<Movie>> list = iMovieClient.getMovieByGenre(genre);
        resultsByGenre.setMovies(list.getBody());

        // obtenemos el puerto
        log.info("Response received from port: {}", list.getHeaders().get("port"));
        return resultsByGenre;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie savedMovie = new Movie();
        ResponseEntity<Movie> movieResponseEntity = iMovieClient.saveMovie(movie);
        savedMovie = movieResponseEntity.getBody();
        return savedMovie;
    }

}