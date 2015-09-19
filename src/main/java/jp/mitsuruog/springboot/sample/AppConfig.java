package jp.mitsuruog.springboot.sample;

import jp.mitsuruog.springboot.sample.service.AddCalculator;
import jp.mitsuruog.springboot.sample.service.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mitsuruog on 15/09/19.
 */
@Configuration
public class AppConfig {

    // DIコンテナで管理したいメソッドに@Beanを付与する。これはSingletonとして管理される
    @Bean
    Calculator calculator() {
        return new AddCalculator();
    }

}
