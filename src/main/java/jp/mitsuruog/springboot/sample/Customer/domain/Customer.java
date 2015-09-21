package jp.mitsuruog.springboot.sample.Customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mitsuruog on 15/09/19.
 */
@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @Size(min = 1, max = 127)
    @Column(nullable = false)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 127)
    @Column(nullable = false)
    private String lastName;
}
