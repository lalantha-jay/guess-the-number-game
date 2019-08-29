package udemy.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

    // == init methods ==
    @PostConstruct
    public void init(){
        log.debug("game = {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage(){
        return ("getMainMessage() method called");
    }

    @Override
    public String getResultMessage() {
        return ("getResultMessage() method called");
    }
}
