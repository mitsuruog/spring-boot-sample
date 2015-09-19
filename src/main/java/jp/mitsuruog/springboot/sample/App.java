package jp.mitsuruog.springboot.sample;

import jp.mitsuruog.springboot.sample.service.ArgumentResolver;
import jp.mitsuruog.springboot.sample.service.CalculationArgument;
import jp.mitsuruog.springboot.sample.service.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

/**
 * Created by mitsuruog on 15/09/19.
 */
@EnableAutoConfiguration
@Import(AppConfig.class)
public class App {

    public static void main(String[] args) {

        try(ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {

            System.out.print("Enter 2 number like 'a b' :");

            // getBeanを用いてDIコンテナからCalculator型とArgumentResolver型のインスタンスを取得する
            ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
            Calculator calculator = context.getBean(Calculator.class);

            // DIコンテナから取得したresolverを実行する
            CalculationArgument argument = argumentResolver.resolve(System.in);

            // calculateにはAddCalculatorクラスが設定されているので、加算となる
            int result = calculator.calculate(argument.getA(), argument.getB());

            System.out.println("result = " + result);

        }

    }

}
