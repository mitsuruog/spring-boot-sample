package jp.mitsuruog.springboot.sample.LeaningSpringDI;

import org.springframework.stereotype.Component;

/**
 * Created by mitsuruog on 15/09/19.
 */
@Component
public class AddCalculator implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
