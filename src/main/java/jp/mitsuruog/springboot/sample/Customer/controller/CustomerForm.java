package jp.mitsuruog.springboot.sample.Customer.controller;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mitsuruog on 15/09/21.
 */
@Data
public class CustomerForm {

    @NotNull
    @Size(min = 1, max = 127)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 127)
    private String lastName;

}
