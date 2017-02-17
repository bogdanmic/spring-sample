package com.gd.spring.services;



import com.gd.spring.models.entities.Movie;

import java.util.List;


public interface MovieService {

    void add(Movie p);
    void update(Movie p);
    List<Movie> list();
    Movie getById(int id);
    void remove(int id);
}
