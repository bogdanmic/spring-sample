package com.gd.spring.elasticsearch.components;


import com.gd.spring.elasticsearch.models.entities.Genre;
import com.gd.spring.elasticsearch.models.entities.Movie;
import com.gd.spring.elasticsearch.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ElasticSearchRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchRunner.class);

    @Autowired
    private MovieService movieService;


    // add star wars and
// princess bride as a movie
// to elastic search
    private void addSomeMovies() {
        Movie starWars = getFirstMovie();
        movieService.addMovie(starWars);

        Movie princessBride = getSecondMovie();
        movieService.addMovie(princessBride);
    }

    private Movie getSecondMovie() {
        Movie secondMovie = new Movie();
        secondMovie.setId(2l);
        secondMovie.setRating(8.4d);
        secondMovie.setName("The Princess Bride");

        List<Genre> princessPrideGenre = new ArrayList< Genre >();
        princessPrideGenre.add(new Genre("ACTION"));
        princessPrideGenre.add(new Genre("ROMANCE"));
        secondMovie.setGenre(princessPrideGenre);

        return secondMovie;
    }


    private Movie getFirstMovie() {
        Movie firstMovie = new Movie();
        firstMovie.setId(1l);
        firstMovie.setRating(9.6d);
        firstMovie.setName("Star Wars");

        List < Genre >  starWarsGenre = new ArrayList < Genre >();
        starWarsGenre.add(new Genre("ACTION"));
        starWarsGenre.add(new Genre("SCI_FI"));
        firstMovie.setGenre(starWarsGenre);

        return firstMovie;
    }

    public void run(String... args) throws Exception {
        addSomeMovies();
        // We indexed star wars and pricess bride to our movie
        // listing in elastic search

        //Lets query if we have a movie with Star Wars as name
        List < Movie > starWarsNameQuery = movieService.getByName("Star Wars");
        logger.info("\nContent of star wars name query is {}", starWarsNameQuery);

        //Lets query if we have a movie with The Princess Bride as name
        List < Movie >  brideQuery = movieService.getByName("The Princess Bride");
        logger.info("\nContent of princess bride name query is {}", brideQuery);


        //Lets query if we have a movie with rating between 6 and 9
        List < Movie >  byRatingInterval = movieService.getByRatingInterval(6d, 9d);
        logger.info("\nContent of Rating Interval query is {}", byRatingInterval);
    }

}
