package yyit.base.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import yyit.base.events.EmailEvent;

@Component
public class EmailPublisher {
    

    private final ApplicationEventPublisher eventPublisher;

    EmailPublisher(ApplicationEventPublisher publisher) {
        this.eventPublisher = publisher;
    }

    public void publishEmailEvent(EmailEvent event) {
        eventPublisher.publishEvent(event);
    }

    public void publishMsgEvent(String msg) {
        eventPublisher.publishEvent(msg);
    }

}
