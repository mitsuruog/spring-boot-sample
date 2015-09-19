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

        String sql = "SELECT 1";
        SqlParameterSource parameter = new MapSqlParameterSource();
        // queryForObject->SQL, パラメータ, 戻り値のクラスを設定する
        Integer result = jdbcTemplate.queryForObject(sql, parameter, Integer.class);
        System.out.println("result -> " + result);

//        // 追加
//        customerService.save(new Customer(1, "Mae", "Matthews"));
//        customerService.save(new Customer(2, "Antonio", "Carr"));
//        customerService.save(new Customer(3, "Ralph", "Henderson"));
//
//        // データ表示
//        customerService.findAll().forEach((x) -> System.out.println(x));

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
