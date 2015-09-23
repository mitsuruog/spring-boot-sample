package jp.mitsuruog.springboot.sample.Customer.service;

import jp.mitsuruog.springboot.sample.Customer.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by mitsuruog on 15/09/23.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {

    private final User user;

    public LoginUserDetails(User user) {
        // AuthorityUtilsを使うことでロールを手早く作成できるらしい。。。
        super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }

}
