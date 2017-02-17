package com.gd.spring.config;

import akka.actor.ActorSystem;
import com.gd.spring.actors.SpringExtension;
import com.gd.spring.actors.WorkerActor;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActorConfig {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private SpringExtension springExtension;

    @Bean
    public ActorSystem actorSystem() {
        ActorSystem system = ActorSystem.create("sample-actor-system", akkaConfiguration());
        springExtension.initialize(applicationContext);

        // Initialize the actors.
        system.actorOf(springExtension.props("workerActor"), WorkerActor.ACTOR_NAME);
        return system;
    }


    private Config akkaConfiguration() {
        return ConfigFactory.load();
    }
}
