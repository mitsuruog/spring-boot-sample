package jp.mitsuruog.springboot.sample.Customer.service;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mitsuruog on 15/09/20.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAllOrderByName(pageable);
    }

    public Customer findById(Integer id) {
        return customerRepository.findOne(id);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.delete(id);
    }
}
