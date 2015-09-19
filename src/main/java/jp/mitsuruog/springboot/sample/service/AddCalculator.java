package jp.mitsuruog.springboot.sample.service;

/**
 * Created by mitsuruog on 15/09/19.
 */
public class AddCalculator implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
