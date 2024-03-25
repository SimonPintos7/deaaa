package com.dh.serieservice.controller;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.service.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }


    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.getSerieByGenre(genre));
    }

    @PostMapping("/save")
    public ResponseEntity<Serie> create(@RequestBody Serie serie) {
        return ResponseEntity.ok().body(serieService.create(serie));
//        return serie.getId();
    }
}
