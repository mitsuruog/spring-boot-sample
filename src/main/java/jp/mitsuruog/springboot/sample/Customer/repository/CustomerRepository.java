package jp.mitsuruog.springboot.sample.Customer.repository;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by mitsuruog on 15/09/20.
 */
// JPAには以下の基本的操作ができる実装クラスがある
// findAll, findOne, save, delete
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // ここは生SQLではなくJPQLというものらしい。なのでCustomerクラスを指定している
    // ページング処理を行うためにPageableを渡して、戻りをPage<T>に変更する
    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    Page<Customer> findAllOrderByName(Pageable pageable);

}
