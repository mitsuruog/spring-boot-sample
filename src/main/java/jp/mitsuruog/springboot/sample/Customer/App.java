package jp.mitsuruog.springboot.sample.Customer;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

        customerRepository.findAll().forEach(customer -> System.out.println(customer));

        // ページング処理
        Pageable pageable = new PageRequest(0, 3);
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        System.out.println("size per 1 page:" + customerPage.getSize());
        System.out.println("current page number:" + customerPage.getNumber());
        System.out.println("total page number:" + customerPage.getTotalPages());
        System.out.println("total customer number:" + customerPage.getTotalElements());

        customerPage.getContent().forEach(customer -> System.out.println(customer));

        customerRepository.findAllOrderByName(pageable).forEach(customer -> System.out.println(customer));

        // TODO うーん、pageable.next()があるけどページングしていないような。。。
        customerRepository.findAllOrderByName(new PageRequest(1, 3)).forEach(customer -> System.out.println(customer));

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
