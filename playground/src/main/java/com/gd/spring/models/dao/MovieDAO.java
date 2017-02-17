package com.gd.spring.models.dao;


import com.gd.spring.models.entities.Movie;

import java.util.List;

public interface MovieDAO {

    void add(Movie p);

    void update(Movie p);

    List<Movie> list();

    Movie getById(int id);

    void remove(int id);
}
