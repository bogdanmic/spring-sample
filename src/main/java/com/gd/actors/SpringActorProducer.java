package com.gd.actors;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

public class SpringActorProducer implements IndirectActorProducer {

    final private ApplicationContext applicationContext;
    final private String beanActorName;
    final private Object[] args;

    public SpringActorProducer(ApplicationContext applicationContext,
                               String beanActorName, Object[] args) {
        this.applicationContext = applicationContext;
        this.beanActorName = beanActorName;
        this.args = args;
    }

    public SpringActorProducer(ApplicationContext applicationContext,
                               String beanActorName) {
        this.applicationContext = applicationContext;
        this.beanActorName = beanActorName;
        this.args = null;
    }

    @Override
    public Actor produce() {
        if (args == null) {
            return (Actor) applicationContext.getBean(beanActorName);
        } else {
            return (Actor) applicationContext.getBean(beanActorName, args);
        }
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(beanActorName);
    }
}

