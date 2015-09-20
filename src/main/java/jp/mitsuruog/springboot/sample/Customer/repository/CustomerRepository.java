package jp.mitsuruog.springboot.sample.Customer.repository;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by mitsuruog on 15/09/19.
 */
@Repository
public class CustomerRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    // 生成されたSQL文を保持する
    SimpleJdbcInsert insert;

    @PostConstruct
    public void init() {
        // SimpleJdbcInsertではinsert文を自動生成する
        // なんで、最初からこれだとダメなのか？？
        insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations())
                .withTableName("customers")
                .usingGeneratedKeyColumns("id"); // これを実行すると自動採番されたIDが返される
    }

    private static final RowMapper<Customer> CUSTOMER_ROW_MAPPER = (rs, rowNum) -> {
        return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
    };

    public List<Customer> findAll() {
        List<Customer> customers = jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers ORDER BY id",
                CUSTOMER_ROW_MAPPER
        );
        return customers;
    }

    public Customer findById(Integer customerId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", customerId);
        return jdbcTemplate.queryForObject(
                "SELECT id, first_name, last_name FROM customers WHERE id = :id",
                parameterSource,
                CUSTOMER_ROW_MAPPER);
    }

    public Customer save(Customer customer) {
        // BeanPropertySqlParameterSourceはbeanの内容をパラメータにMapする便利なものらしい
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(customer);
        if(customer.getId() == null) {
            // insert後のIDを取得する
            Number key = insert.executeAndReturnKey(parameterSource);
            customer.setId(key.intValue());
        } else {
            jdbcTemplate.update(
                    "UPDATE customers SET first_name = :firstName, last_name = :lastName WHERE id = :id",
                    parameterSource
            );
        }
        return customer;
    }

    public void delete(Integer customerId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", customerId);
        jdbcTemplate.update(
                "DELETE FROM customers WHERE id = :id",
                parameterSource
        );
    }

}
