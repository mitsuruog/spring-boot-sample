package jp.mitsuruog.springboot.sample;

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

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter 2 number like 'a b' :");

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // getBeanを用いてDIコンテナからCalculator型のインスタンスを取得する
            Calculator calculator = context.getBean(Calculator.class);
            // calculateにはAddCalculatorクラスが設定されているので、加算となる
            int result = calculator.calculate(a, b);

            System.out.println("result = " + result);

        }

    }

}
