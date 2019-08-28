package udemy.learnspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "udemy.learnspring") // use bean scanning method
public class AppConfig {

    /*  Bean methods can be used instead of Annotations, if additional
        configuration is requred for the bean
    */
    // == Bean methods ==
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

}
