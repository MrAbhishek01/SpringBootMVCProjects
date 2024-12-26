package com.abhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.abhi.model.Customer;

@Controller
public class CustomerOperationController {

    @GetMapping("/")
    public String showHome() {
        return "welcome";
    }

    @GetMapping("/registor")
    public String showRegistrationPage(@ModelAttribute Customer customer) {
        return "registerCustomer";
    }
}
	