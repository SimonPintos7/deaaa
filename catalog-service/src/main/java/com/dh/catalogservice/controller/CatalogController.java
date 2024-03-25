package com.dh.catalogservice.controller;

import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // Obtener Movies y Series por su género
    @GetMapping("/{genre}")
    public ResponseEntity<Genre> getCatalogByGenre (@PathVariable String genre) {
        return ResponseEntity.ok(catalogService.findByGenre(genre));
    }

    // Crear movies
    @PostMapping("/movies/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(catalogService.saveMovie(movie));
    }

    // Crear series
    @PostMapping("/series/save")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie) {
        return ResponseEntity.ok(catalogService.create(serie));
    }
}
