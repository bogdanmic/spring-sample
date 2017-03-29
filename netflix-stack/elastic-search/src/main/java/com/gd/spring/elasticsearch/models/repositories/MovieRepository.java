package com.gd.spring.elasticsearch.models.repositories;

import com.gd.spring.elasticsearch.models.entities.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {
    List<Movie> findByName(String name);

    List<Movie> findByRatingBetween(Double beginning, Double end);
}