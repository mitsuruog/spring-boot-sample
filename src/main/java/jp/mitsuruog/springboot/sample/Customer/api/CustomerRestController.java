package jp.mitsuruog.springboot.sample.Customer.api;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by mitsuruog on 15/09/20.
 */
@RestController
@RequestMapping("api/members")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    // value属性は相対パス指定のこと
    // pathパラメータを取得するには、@PathVariableを設定、プレースホルダと変数名は一致させておくこと
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        return customer;
    }

    // デフォルトのContent-Typeはapplication/jsonみたい。。。
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer createCustomer(@RequestBody Customer customer) {
        Customer created = customerService.create(customer);
        return created;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        Customer updated = customerService.update(customer);
        return customer;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
    }

}
