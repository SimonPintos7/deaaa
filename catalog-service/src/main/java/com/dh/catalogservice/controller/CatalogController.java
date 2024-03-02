package com.dh.catalogservice.controller;

import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<Genre> getCatalogByGenre (@PathVariable String genre) throws GenreNotFoundException {
        return ResponseEntity.ok(catalogService.findByGenre(genre));
    }

    @PostMapping("/movies/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        catalogService.saveMovie(movie);
        return ResponseEntity.noContent().build();
    }
}
