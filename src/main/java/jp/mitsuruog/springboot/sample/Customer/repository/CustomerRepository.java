package jp.mitsuruog.springboot.sample.Customer.repository;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mitsuruog on 15/09/20.
 */
// JPAには以下の基本的操作ができる実装クラスがある
// findAll, findOne, save, delete
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
