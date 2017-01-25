package com.gd.controllers;

import com.gd.models.entities.Movie;
import com.gd.models.entities.Actor;
import com.gd.services.ActorService;
import com.gd.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DBController {
    private final MovieService movieService;
    private final ActorService actorService;

    //TODO: Maybe make this to use multiple databases.

    @Autowired
    public DBController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }


    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> listMovies() {
        return movieService.list();
    }

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public List<Actor> listActors() {
        return actorService.list();
    }

}
