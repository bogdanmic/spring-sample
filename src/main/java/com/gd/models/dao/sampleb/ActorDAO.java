package com.gd.models.dao.sampleb;

import com.gd.models.entities.sampleb.Actor;

import java.util.List;

public interface ActorDAO {

    void add(Actor p);

    void update(Actor p);

    List<Actor> list();

    Actor getById(int id);

    void remove(int id);
}
