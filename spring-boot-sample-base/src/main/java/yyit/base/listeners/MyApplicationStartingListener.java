package yyit.base.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationStartingListener {

    Logger logger = LoggerFactory.getLogger(MyApplicationStartingListener.class);

    @EventListener(ContextRefreshedEvent.class)
    @Async
    public void ContextRefreshedEventExecute() {
        logger.debug("上下文事件侦听器正在执行");
    }

}
