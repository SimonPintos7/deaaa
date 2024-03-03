package com.dh.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie{

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
