package com.dh.catalogservice.service;

import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.GenreSeries;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CatalogService {

    Genre findByGenre(String genre);

    Movie saveMovie(Movie movie);

    GenreSeries getSerieByGenre(String genre);
    Serie saveSerie(Serie serie);
}
