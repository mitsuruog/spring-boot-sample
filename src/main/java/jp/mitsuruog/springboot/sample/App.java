package jp.mitsuruog.springboot.sample;

import jp.mitsuruog.springboot.sample.service.ArgumentResolver;
import jp.mitsuruog.springboot.sample.service.CalculationArgument;
import jp.mitsuruog.springboot.sample.service.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

/**
 * Created by mitsuruog on 15/09/19.
 */
@EnableAutoConfiguration
// @ComponentScanを付けるとこのクラスと同じパッケージ以下のスキャンする。
// 対象は@Component, @Service, @Repository, @Controllerなど、、、などって何だ？？
// basePackagesで対象を変えることができる。
@ComponentScan
public class App {

    public static void main(String[] args) {

        try(ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {

            Fronted fronted = context.getBean(Fronted.class);
            fronted.run();

        }

    }

}
