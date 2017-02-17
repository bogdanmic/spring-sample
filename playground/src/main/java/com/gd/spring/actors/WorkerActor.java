package com.gd.spring.actors;

import akka.actor.UntypedActor;
import com.gd.spring.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WorkerActor extends UntypedActor {
    public static final String ACTOR_NAME = "worker-actor";
    public static final String ACTOR_PATH = "/user/" + ACTOR_NAME;

    // Inspired by:
    //      http://www.baeldung.com/akka-with-spring
    //      https://www.linkedin.com/pulse/spring-boot-akka-part-1-aliaksandr-liakh
    //      https://www.linkedin.com/pulse/spring-boot-akka-part-2-aliaksandr-liakh

    @Autowired
    private BusinessService businessService;
    private int count = 0;

    // constructor

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Request) {
            businessService.perform(this + " " + (++count));

        } else if (message instanceof Response) {
            getSender().tell(count, getSelf());
        } else {
            unhandled(message);
        }
    }

    public static class Request {

    }

    public static class Response {

    }
}
