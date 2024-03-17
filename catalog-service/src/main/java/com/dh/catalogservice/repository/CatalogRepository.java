package com.dh.catalogservice.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Movie, String>{
}
