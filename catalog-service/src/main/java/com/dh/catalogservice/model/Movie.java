package com.dh.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie{

    @Id
    private Long id;
    private String name;
    private String genre;
    private String urlStream;

}
