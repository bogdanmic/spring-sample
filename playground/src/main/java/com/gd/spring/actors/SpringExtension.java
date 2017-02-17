package com.gd.spring.actors;

import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringExtension implements Extension {
    private volatile ApplicationContext applicationContext;

    public void initialize(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Props props(String actorBeanName) {
        return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
    }

    public Props props(String actorBeanName, Object... args) {
        return Props.create(SpringActorProducer.class, applicationContext, actorBeanName, args);
    }
}