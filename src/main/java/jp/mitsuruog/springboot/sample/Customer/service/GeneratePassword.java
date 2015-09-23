package jp.mitsuruog.springboot.sample.Customer.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by mitsuruog on 15/09/24.
 */
public class GeneratePassword {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("test"));
    }
}
