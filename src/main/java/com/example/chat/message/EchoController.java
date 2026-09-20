package com.example.chat.message;

import com.example.chat.message.dto.EchoRequest;
import com.example.chat.message.dto.EchoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.time.Instant;

@Slf4j
@Controller
public class EchoController {

    @MessageMapping("/echo")
    @SendTo("/topic/echo")
    public EchoResponse echo(EchoRequest req, Principal principal) {

        log.debug("여기로 오긴 하는거니?");
        return new EchoResponse(principal.getName(), req.content(), Instant.now());
    }
}
