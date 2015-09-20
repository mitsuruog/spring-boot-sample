package jp.mitsuruog.springboot.sample.Customer.controller;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mitsuruog on 15/09/20.
 */
@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // Spring MVCの画面に値を返すにはModelを利用する
    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        Page<Customer> customers = customerService.findAll(new PageRequest(0,20));
        model.addAttribute("customers", customers);
        // Spring bootでは画面のパスは「templates/customers/list.html」となる
        return "customers/list";
    }

}
