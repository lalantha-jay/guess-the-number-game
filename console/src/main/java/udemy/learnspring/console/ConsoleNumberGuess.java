package udemy.learnspring.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// Using Annotations to Handle Events
@Component
public class ConsoleNumberGuess {
    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //@EventListener
    // With annotations you can rename the method, here as "start"
    /* However ContextRefreshedEvent contextRefreshedEvent is not being used here
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start() --> Container ready for use.");
    }
    */
    // Therefore rather than using a parameter that is not used,
    // we can add an Event Type to the EventListener annotation.
    @EventListener(ContextRefreshedEvent.class)
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start() --> Container ready for use.");
    }
}

/* Another older method is to implement the ApplicationListener
@Component
public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Container ready for use.");
    }
}
*/
