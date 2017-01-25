package com.gd.models.dao;

import com.gd.models.entities.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class MovieDAOImpl implements MovieDAO {

    private static final Logger logger = LoggerFactory.getLogger(MovieDAOImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Movie p) {
        em.persist(p);
        logger.info("Movie saved successfully, Phone Details=" + p);
    }

    @Override
    public void update(Movie p) {
        em.merge(p);
        logger.info("Movie updated successfully, Movie Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Movie> list() {
        List<Movie> phonesList = em.createQuery("from Movie").getResultList();
        for (Movie p : phonesList) {
            logger.info("Movie List::" + p);
        }
        return phonesList;
    }

    @Override
    public Movie getById(int id) {

        Movie p = (Movie) em.find(Movie.class, new Integer(id));
        logger.info("Movie loaded successfully, Phone details=" + p);
        return p;
    }

    @Override
    public void remove(int id) {
        Movie p = (Movie) em.find(Movie.class, new Integer(id));
        if (null != p) {
            em.remove(p);
        }
        logger.info("Movie deleted successfully, phone details=" + p);
    }
}
