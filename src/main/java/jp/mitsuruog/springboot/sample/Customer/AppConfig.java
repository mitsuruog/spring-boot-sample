package jp.mitsuruog.springboot.sample.Customer;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by mitsuruog on 15/09/20.
 */
@Configuration
public class AppConfig {

    @Autowired
    DataSourceProperties dataSourceProperties;
    DataSource dataSource;

    @Bean(destroyMethod = "close")
    DataSource realDataSource() {
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword());
        this.dataSource = factory.build();
        return this.dataSource;
    }

    // @Primaryは
    // Spring Boot 1.2.3に上げるとDataSourceの作成に失敗する件、らしい。。。
    // making/hajiboot-samples https://github.com/making/hajiboot-samples#spring-boot-123に上げるとdatasourceの作成に失敗する
    @Primary
    @Bean
    DataSource dataSource() {
        return new Log4jdbcProxyDataSource(this.dataSource);
    }
}

