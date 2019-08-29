package udemy.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;

// If using Componenet Scanning and Annotations, uncomment below line
//@Component("generator") // name the bean
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    // -- public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
