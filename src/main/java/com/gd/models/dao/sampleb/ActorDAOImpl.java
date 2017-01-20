package com.gd.models.dao.sampleb;

import com.gd.models.entities.sampleb.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ActorDAOImpl implements ActorDAO {

    private static final Logger logger = LoggerFactory.getLogger(ActorDAOImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Actor p) {
        em.persist(p);
        logger.info("Actor saved successfully, Actor Details=" + p);
    }

    @Override
    public void update(Actor p) {
        em.merge(p);
        logger.info("Actor updated successfully, Movie Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Actor> list() {
        List<Actor> phonesList = em.createQuery("from Actor").getResultList();
        for (Actor p : phonesList) {
            logger.info("Actor List::" + p);
        }
        return phonesList;
    }

    @Override
    public Actor getById(int id) {

        Actor p = (Actor) em.find(Actor.class, new Integer(id));
        logger.info("Movie loaded successfully, Phone details=" + p);
        return p;
    }

    @Override
    public void remove(int id) {
        Actor p = (Actor) em.find(Actor.class, new Integer(id));
        if (null != p) {
            em.remove(p);
        }
        logger.info("Movie deleted successfully, phone details=" + p);
    }
}
