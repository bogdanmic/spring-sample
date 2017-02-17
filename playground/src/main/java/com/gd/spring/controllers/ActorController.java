package com.gd.spring.controllers;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.gd.spring.actors.WorkerActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

import java.util.concurrent.TimeUnit;

@RestController
public class ActorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActorSystem system;


    @RequestMapping(value = "/actor", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getActorGreeting() throws Exception {
        ActorSelection workerActor = system.actorSelection(WorkerActor.ACTOR_PATH);


        workerActor.tell(new WorkerActor.Request(), ActorRef.noSender());
        workerActor.tell(new WorkerActor.Request(), ActorRef.noSender());
        workerActor.tell(new WorkerActor.Request(), ActorRef.noSender());

        FiniteDuration duration = FiniteDuration.create(3, TimeUnit.SECONDS);
        Timeout timeout = Timeout.durationToTimeout(duration);
        Future<Object> awaitable = Patterns.ask(workerActor, new WorkerActor.Response(), timeout);

        try {
            logger.info("---> ACTOR Path: {}. Response: {}", Await.result(awaitable, duration));
        } finally {
            // If we terminate the actor system then the controller when called the second time will throw an error.
            // system.terminate();
            // Await.result(system.whenTerminated(), Duration.Inf());
        }
        return "Actor Done";
    }
}
