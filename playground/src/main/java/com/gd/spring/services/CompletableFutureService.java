package com.gd.spring.services;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.gd.spring.actors.SpringExtension;
import com.gd.spring.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CompletableFutureService {

    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private SpringExtension springExtension;

    public CompletableFuture<MessageDTO> get(String payload, Long id) {
        CompletableFuture<MessageDTO> future = new CompletableFuture<>();
        ActorRef messageActor = actorSystem.actorOf(springExtension.props("messageActor", future), "message-actor");
        messageActor.tell(new MessageDTO(payload, id), ActorRef.noSender());
        return future;

    }
}
