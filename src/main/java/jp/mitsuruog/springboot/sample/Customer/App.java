package jp.mitsuruog.springboot.sample.Customer;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.repository.CustomerRepository;
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
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        customerRepository.save(new Customer(null, "Mae", "Matthews"));
        customerRepository.save(new Customer(null, "Antonio", "Carr"));
        customerRepository.save(new Customer(null, "Ralph", "Henderson"));
        customerRepository.save(new Customer(null, "Ted", "Fowler"));
        customerRepository.save(new Customer(null, "Mitsuru", "Ogawa"));

        customerRepository.findAll().forEach(customer -> System.out.println(customer));

        customerRepository.findAllOrderByName().forEach(customer -> System.out.println(customer));

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
