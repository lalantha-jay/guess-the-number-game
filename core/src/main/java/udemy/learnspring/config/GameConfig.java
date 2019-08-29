package udemy.learnspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import udemy.learnspring.GuessCount;
import udemy.learnspring.MaxNumber;

@Configuration
public class GameConfig {

    // == fields ==
    private int maxNumber = 25;
    private int guessCount = 8;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

}
