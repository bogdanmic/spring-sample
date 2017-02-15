package com.gd.actors;

import akka.actor.UntypedActor;
import com.gd.dto.MessageDTO;
import com.gd.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageActor extends UntypedActor {

    // Inspired by:
    //      http://www.baeldung.com/akka-with-spring
    //      https://www.linkedin.com/pulse/spring-boot-akka-part-1-aliaksandr-liakh
    //      https://www.linkedin.com/pulse/spring-boot-akka-part-2-aliaksandr-liakh

    @Autowired
    private BusinessService businessService;

    final private CompletableFuture<MessageDTO> future;

    // constructor
    public MessageActor(CompletableFuture<MessageDTO> future) {
        this.future = future;
    }


    @Override
    public void onReceive(Object message) throws Throwable {
        businessService.perform(this + " " + message);
        if (message instanceof MessageDTO) {
            future.complete((MessageDTO) message);
        } else {
            unhandled(message);
        }

        getContext().stop(self());
    }

}
