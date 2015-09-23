package jp.mitsuruog.springboot.sample.Customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mitsuruog on 15/09/24.
 */
@Controller
public class LoginController {

    @RequestMapping("loginForm")
    String loginForm() {
        return "loginForm";
    }
}
