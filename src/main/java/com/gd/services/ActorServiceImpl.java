package com.gd.services;


import com.gd.models.dao.sampleb.ActorDAO;
import com.gd.models.entities.sampleb.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ActorServiceImpl implements ActorService {

    private ActorDAO dao;

    @Autowired
    public void setDao(ActorDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional("primaryTransactionManager")
    public void add(Actor p) {
        this.dao.add(p);
    }

    @Override
    @Transactional("primaryTransactionManager")
    public void update(Actor p) {
        this.dao.update(p);
    }

    @Override
    @Transactional("primaryTransactionManager")
    public List<Actor> list() {
        return this.dao.list();
    }

    @Override
    @Transactional("primaryTransactionManager")
    public Actor getById(int id) {
        return this.dao.getById(id);
    }

    @Override
    @Transactional("primaryTransactionManager")
    public void remove(int id) {
        this.dao.remove(id);
    }
}
