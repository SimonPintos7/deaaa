package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private IMovieClient iMovieClient;

    public CatalogServiceImpl(IMovieClient iMovieClient) {
        this.iMovieClient = iMovieClient;
    }

    @Override
    public Genre findByGenre(String genre)  {
        return new Genre(iMovieClient.getMovieByGenre(genre));
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return iMovieClient.saveMovie(movie);
    }
}
