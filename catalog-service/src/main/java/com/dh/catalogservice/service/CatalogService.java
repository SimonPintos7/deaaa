package com.dh.catalogservice.service;

import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CatalogService {

    Genre findByGenre(String genre);

    Movie saveMovie(Movie movie);
}
