package jp.mitsuruog.springboot.sample.LeaningSpringDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by mitsuruog on 15/09/19.
 */
@EnableAutoConfiguration
// @ComponentScanを付けるとこのクラスと同じパッケージ以下のスキャンする。
// 対象は@Component, @Service, @Repository, @Controllerなど、、、などって何だ？？
// basePackagesで対象を変えることができる。
@ComponentScan
public class App implements CommandLineRunner {

    // @Autowiredするとcontext.getBean()を自動で行ってくれる
    @Autowired
    Calculator calculator;
    @Autowired
    ArgumentResolver argumentResolver;

    @Override
    public void run(String... args) throws Exception {
        System.out.print("Enter 2 number like 'a b' :");

        CalculationArgument argument = argumentResolver.resolve(System.in);
        int result = calculator.calculate(argument.getA(), argument.getB());

        System.out.println("result = " + result);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
