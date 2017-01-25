package com.gd.services;

import com.gd.models.entities.Actor;

import java.util.List;

public interface ActorService {

    void add(Actor p);

    void update(Actor p);

    List<Actor> list();

    Actor getById(int id);

    void remove(int id);
}
