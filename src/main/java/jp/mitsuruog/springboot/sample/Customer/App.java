package jp.mitsuruog.springboot.sample.Customer;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

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

        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("id", 1);
        // queryForObject->SQL, パラメータ, 戻り値のクラスを設定する
        Customer result = jdbcTemplate.queryForObject(sql, parameter, (rs, rowNum) ->
                        new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"))
        );
        System.out.println("result -> " + result);

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
