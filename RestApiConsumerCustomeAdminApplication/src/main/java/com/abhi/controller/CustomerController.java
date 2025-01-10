package com.abhi.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abhi.models.Customer;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private RestTemplate restTemplate;

	private static final String PRODUCER_BASE_URL = "http://localhost:8089/RestApiProducerCustomeAdminApplication/api/customers";

	
	
	
	
	@GetMapping("/insideCustomerLoginPage")
	public String insideCustomerLoginPage(HttpSession session) {
	    if (session.getAttribute("loggedInCustomer") == null) {
	        return "redirect:/customer/login"; // Agar login nahi kiya hai toh login page par bhej do
	    }
	    return "customer/insideCustomerLoginPage"; // JSP file ka naam
	}

	
	// Customer Login Page (GET)
	@GetMapping("/login")
	public String loginCustomerPage(@ModelAttribute Customer customer) {
		return "customer/customerLogin"; // Ensure the login page view exists
	}

	// Customer Login (POST)
	@PostMapping("/login")
	public String loginCustomer(@ModelAttribute Customer customer, Map<String, Object> map, HttpSession session) {
		String url = PRODUCER_BASE_URL + "/login";
		
		
		try {

			Map<String, Object> loginResult = restTemplate.postForObject(url, customer, Map.class);
			session.setAttribute("loggedInCustomer", loginResult.get("customer"));
			map.put("message", "Login successful!");
			return "customer/insideCustomerLoginPage"; // Redirect to dashboard
		} catch (Exception e) {
			map.put("message", "Login failed! Invalid credentials.");
			return "customer/customerLogin"; // Stay on login page
		}
	}

	// Customer Registration Page (GET)
	@GetMapping("/customerRegisterPage")
	public String showCustomerRegisterPage(@ModelAttribute Customer customer) {
		return "customer/registerCustomer"; // Registration page view
	}

	// Customer Registration (POST)
	@PostMapping("/customerRegisterPage")
	public String registerCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
		String url = PRODUCER_BASE_URL + "/registor";
		try {
			String postForLocation = restTemplate.postForObject(url, customer, String.class);
			redirectAttributes.addFlashAttribute("message", postForLocation);
		} catch (ResourceAccessException e) {
			redirectAttributes.addFlashAttribute("message", "Producer service is unavailable.");
		}
		return "redirect:/customer/login"; // Redirect to login page
	}

	// Customer Logout (GET)
	@GetMapping("/logout")
	public String customerLogout(RedirectAttributes redirectAttributes) {
		// Logout doesn't involve calling the producer, just invalidate the session
		redirectAttributes.addFlashAttribute("message", "Logged out successfully!");
		return "redirect:/customer/login"; // Redirect to login page
	}

	
	
	@GetMapping("/editCustomerProfile")
	public String editCustomerProfile(@RequestParam("customerId") Integer customerId, 
	                                  Customer customer, HttpSession session) {
	    String url = PRODUCER_BASE_URL + "/update/" + customerId;
	    Customer fetchedCustomerDetails = restTemplate.getForObject(url, Customer.class);
	    BeanUtils.copyProperties(fetchedCustomerDetails, customer);
	    session.setAttribute("loggedInCustomer", customer);
	    return "customer/customerEditPage"; // Profile edit page view
	}

	

	// Update Customer Profile (POST)
	@PostMapping("/editCustomerProfile")
	public String updateCustomerProfile(@ModelAttribute Customer customer, Map<String, Object>map,HttpSession session) {
		String url = PRODUCER_BASE_URL + "/update";
		System.out.println(customer.getCustomerUsername());
		restTemplate.put(url, customer);
		 session.setAttribute("loggedInCustomer", customer);
		map.put("message", "Profile updated successfully!");
		return "customer/insideCustomerLoginPage"; // Redirect to dashboard
	}
	
	
	

	// Forgot Password Page (GET)
	@GetMapping("/forgotPassword")
	public String forgotPasswordPage(@ModelAttribute Customer customer) {
		return "customer/forgotCustomerPasswordPage"; // Forgot password view
	}

	// Check User ID for Password Reset (POST)
	@PostMapping("/checkUserId")
	public String checkUserId(@ModelAttribute Customer customer, Model model) {
		String url = PRODUCER_BASE_URL + "/forgot-password/check-user";
		ResponseEntity<Map> response = restTemplate.postForEntity(url, customer, Map.class);
		model.addAttribute("message", response.getBody().get("message"));
		model.addAttribute("idExists", response.getBody().get("idExists"));
		return "customer/forgotCustomerPasswordPage"; // Stay on the forgot password page
	}

	// Update Customer Password (POST)
	@PostMapping("/updatePassword")
	public String updatePassword(@RequestParam("customerUsername") Integer customerUsername,
			@RequestParam("customerPassword") String customerPassword, RedirectAttributes redirectAttributes) {
		String url = PRODUCER_BASE_URL + "/forgot-password/update";
		Map<String, Object> payload = Map.of("customerUsername", customerUsername, "customerPassword",
				customerPassword);
		ResponseEntity<Map> response = restTemplate.postForEntity(url, payload, Map.class);
		redirectAttributes.addFlashAttribute("message", response.getBody().get("message"));
		return "redirect:/customer/login"; // Redirect to login page
	}
}
