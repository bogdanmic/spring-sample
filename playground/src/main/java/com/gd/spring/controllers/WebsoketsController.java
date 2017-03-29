package com.gd.spring.controllers;

import com.gd.spring.dto.HelloMessage;
import com.gd.spring.dto.SalutationsMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsoketsController {
    /**
     * More details at: https://spring.io/guides/gs/messaging-stomp-websocket/
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public SalutationsMessage greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new SalutationsMessage("Hello, " + message.getName() + "!");
    }
}
