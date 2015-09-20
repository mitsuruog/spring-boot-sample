package jp.mitsuruog.springboot.sample.Customer;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by mitsuruog on 15/09/19.
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner{

    @Autowired
    CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {

        Customer created = customerService.save(new Customer(null, "mitsuru", "ogawa"));
        System.out.println(created + "is created!!");

        customerService.findAll().forEach(
                (customer) -> System.out.println(customer));

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
