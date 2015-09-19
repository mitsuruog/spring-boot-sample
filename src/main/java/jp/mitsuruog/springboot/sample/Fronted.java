package jp.mitsuruog.springboot.sample;

import jp.mitsuruog.springboot.sample.service.ArgumentResolver;
import jp.mitsuruog.springboot.sample.service.CalculationArgument;
import jp.mitsuruog.springboot.sample.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mitsuruog on 15/09/19.
 */

public class Fronted {

    // @Autowiredするとcontext.getBean()を自動で行ってくれる
    @Autowired
    Calculator calculator;

    @Autowired
    ArgumentResolver argumentResolver;

    public void run() {
        System.out.print("Enter 2 number like 'a b' :");

        CalculationArgument argument = argumentResolver.resolve(System.in);
        int result = calculator.calculate(argument.getA(), argument.getB());

        System.out.println("result = " + result);
    }
}
