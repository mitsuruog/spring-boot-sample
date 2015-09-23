package jp.mitsuruog.springboot.sample.Customer.repository;

import jp.mitsuruog.springboot.sample.Customer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mitsuruog on 15/09/23.
 */
public interface UserRepository extends JpaRepository<User, String> {
}
