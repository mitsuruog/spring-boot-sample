package jp.mitsuruog.springboot.sample.Customer.api;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

/**
 * Created by mitsuruog on 15/09/20.
 */
@RestController
@RequestMapping("api/members")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    // @PageableDefaultのデフォルトはpage=0, size=20
    // リクエストパラメータでページングは制御できる。（例）?page=1&size=20とか
    @RequestMapping(method = RequestMethod.GET)
    Page<Customer> getCustomers(@PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
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
    ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
        Customer created = customerService.create(customer);

        // 作成したリソースへのURIをLocationヘッダで返却する
        URI location = uriBuilder.path("api/customers/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer updateCustomer(@PathVariable Integer id, @Validated @RequestBody Customer customer) {
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
