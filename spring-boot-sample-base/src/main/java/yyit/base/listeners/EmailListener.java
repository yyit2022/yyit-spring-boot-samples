package yyit.base.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import yyit.base.events.EmailEvent;

@Component
public class EmailListener {

    @Async
    @EventListener
    void sendMsgEvent(EmailEvent emailEvent) {
        System.out.println("==EmailListener 1 ===" + emailEvent.getMessage());
    }

    @Async
    @EventListener
    void sendMsgEvent(String message) {
        System.out.println("==EmailListener 2 ===" + message);
    }
}
