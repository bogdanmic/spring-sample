package com.gd.spring.services;


import com.gd.spring.models.dao.MovieDAO;
import com.gd.spring.models.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    private MovieDAO dao;

    @Autowired
    public void setDao(MovieDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(Movie p) {
        this.dao.add(p);
    }

    @Override
    @Transactional
    public void update(Movie p) {
        this.dao.update(p);
    }

    @Transactional
    public List<Movie> list() {
        return this.dao.list();
    }

    @Override
    @Transactional
    public Movie getById(int id) {
        return this.dao.getById(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.dao.remove(id);
    }
}
