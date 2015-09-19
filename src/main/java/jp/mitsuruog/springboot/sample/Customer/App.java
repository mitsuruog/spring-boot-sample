package jp.mitsuruog.springboot.sample.Customer;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Created by mitsuruog on 15/09/19.
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner{

//    @Autowired
//    CustomerService customerService;

    // autoconfigureという仕組みで依存関係を設定せずにSpring boot側で勝手にDIコンテナに登録されるみたい
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        String sql = "SELECT :a + :b";
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("a", 100)
                .addValue("b", 200);
        // queryForObject->SQL, パラメータ, 戻り値のクラスを設定する
        Integer result = jdbcTemplate.queryForObject(sql, parameter, Integer.class);
        System.out.println("result -> " + result);

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
