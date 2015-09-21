package jp.mitsuruog.springboot.sample.Customer.controller;

import jp.mitsuruog.springboot.sample.Customer.domain.Customer;
import jp.mitsuruog.springboot.sample.Customer.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    // @ModelAttributeを付与したメソッドは@RequestMapping処理の直前で実行される
    // 戻り値はModelに設定される
    // テストのbeforeEachみたいなもの
    @ModelAttribute
    CustomerForm setUpForm() {
        return new CustomerForm();
    }

    // Spring MVCの画面に値を返すにはModelを利用する
    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        Page<Customer> customers = customerService.findAll(new PageRequest(0,20));
        model.addAttribute("customers", customers);
        // Spring bootでは画面のパスは「templates/customers/list.html」となる
        return "customers/list";
    }

    // @ValidatedでFormが評価される、結果はBindingResultに入っている
    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated CustomerForm form, BindingResult result, Model model) {
        if(result.hasErrors()) {
            // エラーがあった場合は、list()を実行して一覧画面を表示している
            return list(model);
        }
        Customer newCustomer = new Customer();
        // BeanUtils.copyProperties <- これ便利だな。。。
        BeanUtils.copyProperties(form, newCustomer);
        customerService.create(newCustomer);
        // リダイレクトする
        return "redirect:/customers";
    }

}
