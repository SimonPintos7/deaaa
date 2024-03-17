package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.IMovieClient;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService{
    private IMovieClient movieClient;

    @Autowired
    public MovieServiceImpl(IMovieClient movieClient){
        this.movieClient = movieClient;
    }

    @CircuitBreaker(name="movies", fallbackMethod = "emptyListFallbackMethod")
    @Retry
    @Override
    public List<Movie> findAll(){
        log.info("Calling movie service...");
        return movieClient.findAll(true);
    }

    public List<Movie> emptyListFallbackMethod(CallNotPermittedException e) {
        return new ArrayList<>();
    }
}
