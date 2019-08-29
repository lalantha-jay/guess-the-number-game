package udemy.learnspring.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import udemy.learnspring.AppConfig;
import udemy.learnspring.Game;
import udemy.learnspring.MessageGenerator;
import udemy.learnspring.NumberGenerator;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    // private static final String CONFIG_LOCATION = "beans.xml";
    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create the context (container), if using XML
        /*
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        */

        // create the context (container) from configuration class
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container),
        // via overloading
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        // call method next() to get a random number
        int num = numberGenerator.next();

        // log generated number
        log.info("number = {}", num);

        // get Message Generator bean from context (container),
        // via overloading
        MessageGenerator messageGenerator
                = context.getBean(MessageGenerator.class);

        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // Initializion method moved to XML file to facilitate
        // bean lifecycle callback via handling by container
        // class reset method
        //game.reset();

        // close context (container)
        context.close();
    }
}
