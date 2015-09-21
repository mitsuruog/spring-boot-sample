package jp.mitsuruog.springboot.sample.Customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mitsuruog on 15/09/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// toStringでcustomersを出力すると循環参照になるので、Lombokの出力対象から除外する
@ToString(exclude = "customers")
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;
    // APIからJSONとして出力される場合にフィールドから除外する
    @JsonIgnore
    private String encodedPassword;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    List<Customer> customers;

}
