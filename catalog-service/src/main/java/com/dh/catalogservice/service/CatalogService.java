package com.dh.catalogservice.service;

import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;

import java.util.List;

public interface CatalogService {

    public Genre findByGenre(String genre) throws GenreNotFoundException;

    public void saveMovie(Movie movie);
}
