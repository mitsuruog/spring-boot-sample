package jp.mitsuruog.springboot.sample.Customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by mitsuruog on 15/09/19.
 */
@Data
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
}
