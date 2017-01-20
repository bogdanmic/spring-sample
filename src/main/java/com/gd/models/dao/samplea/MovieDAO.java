package com.gd.models.dao.samplea;

import com.gd.models.entities.samplea.Movie;

import java.util.List;

public interface MovieDAO {

    void add(Movie p);

    void update(Movie p);

    List<Movie> list();

    Movie getById(int id);

    void remove(int id);
}
