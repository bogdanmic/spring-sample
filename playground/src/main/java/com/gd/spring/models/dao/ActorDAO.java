package com.gd.spring.models.dao;


import com.gd.spring.models.entities.Actor;

import java.util.List;

public interface ActorDAO {

    void add(Actor p);

    void update(Actor p);

    List<Actor> list();

    Actor getById(int id);

    void remove(int id);
}
