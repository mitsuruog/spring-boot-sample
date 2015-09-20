package jp.mitsuruog.springboot.sample.Customer.repository;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by mitsuruog on 15/09/20.
 */
// JPAには以下の基本的操作ができる実装クラスがある
// findAll, findOne, save, delete
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // ここは生SQLではなくJPQLというものらしい。なのでCustomerクラスを指定している
    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    List<Customer> findAllOrderByName();

}
