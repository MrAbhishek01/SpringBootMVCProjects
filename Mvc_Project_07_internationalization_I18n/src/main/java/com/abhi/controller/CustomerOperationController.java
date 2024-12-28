package com.abhi.controller;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.abhi.model.Customer;

@Controller
public class CustomerOperationController {

	@GetMapping("/")
    public String showHome(Map<String, Object> map, Locale locale) {
        map.put("locale", locale);
        map.put("date", new Date());  // Current date
        map.put("salary", 88556.5);  // Example salary value
        map.put("avg", 56.5);  // Example average value
        return "welcome";  // Name of the JSP file (welcome.jsp)
    }

    @GetMapping("/registor")
    public String showRegistrationPage(@ModelAttribute Customer customer) {
        return "registerCustomer";
    }
}
	