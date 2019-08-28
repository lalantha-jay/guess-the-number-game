package udemy.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";
    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create the context (container)
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get number generator bean from context (container),
        // via overloading
        NumberGenerator numberGenerator
                = context.getBean("numberGenerator", NumberGenerator.class);

        // call method next() to get a random number
        int num = numberGenerator.next();

        // log generated number
        log.info("number = {}", num);

        // get the game bean from context (container)
        Game game = context.getBean(Game.class);

        // Initializion method moved to XML file to facilitate
        // bean lifecycle callback via handling by container
        // class reset method
        //game.reset();

        // close context (container)
        context.close();
    }
}
