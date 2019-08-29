package udemy.learnspring.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import udemy.learnspring.Game;
import udemy.learnspring.MessageGenerator;

import java.util.Scanner;

// Using Annotations to Handle Events
@Component
public class ConsoleNumberGuess {
    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
    @Autowired
    private Game game;
    @Autowired
    private MessageGenerator messageGenerator;

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
    public void start() {
        log.info("start() --> Container ready for use.");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int  guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }

                game.reset();
            }
        }
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
