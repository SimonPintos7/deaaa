package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.MovieService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {
    private IMovieClient movieClient;

    @Autowired
    public MovieServiceImpl(IMovieClient movieClient){
        this.movieClient = movieClient;
    }

    @CircuitBreaker(name="movies", fallbackMethod = "emptyListFallbackMethod")
    @Retry(name="movies")
    @Override
    public List<Movie> findAll(){
        log.info("Calling movie service...");
        return movieClient.findAll(false);
    }

    public List<Movie> emptyListFallbackMethod(CallNotPermittedException e) {
        return new ArrayList<>();
    }
}
