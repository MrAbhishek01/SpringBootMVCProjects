package com.abhi.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.models.Customer;
import com.abhi.service.ICustomerService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	// Customer Login (POST)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginCustomer(@RequestBody Customer customer, HttpSession session) {
		Customer loggedInCustomer = customerService.loginCustomer(customer);
		if (loggedInCustomer == null) {
			return new ResponseEntity<>(Map.of("message", "Login failed! Invalid credentials."),
					HttpStatus.UNAUTHORIZED);
		}
		session.setAttribute("loggedInCustomer", loggedInCustomer);
		return new ResponseEntity<>(Map.of("message", "Login successful!", "customer", loggedInCustomer),
				HttpStatus.OK);
	}

	// Customer Registration (POST)

	@PostMapping("/registor")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		String message = customerService.registerCustomer(customer);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

	// Customer Logout (GET)
	@GetMapping("/logout")
	public ResponseEntity<Map<String, String>> customerLogout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<>(Map.of("message", "Logged out successfully!"), HttpStatus.OK);
	}

	// Edit Customer Profile (GET)
	@GetMapping("/update/{customerId}")
	public ResponseEntity<Customer> getCustomerProfile(@PathVariable Integer customerId) {
		Customer fetchedCustomerDetails = customerService.fatchCustomerDetailsById(customerId);
		return new ResponseEntity<>(fetchedCustomerDetails, HttpStatus.OK);
	}


	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomerProfile(@RequestBody Customer customer, HttpSession session) {
	    String message = customerService.updateCustomerDetails(customer);
	    session.setAttribute("loggedInCustomer", customer);
	    return new ResponseEntity<>(message, HttpStatus.OK);
	}


	// Forgot Password Page (GET)
	@GetMapping("/forgot-password")
	public ResponseEntity<Map<String, String>> forgotPasswordPage() {
		return new ResponseEntity<>(Map.of("message", "Forgot password page available!"), HttpStatus.OK);
	}

	// Check User ID for Password Reset (POST)
	@PostMapping("/forgot-password/check-user")
	public ResponseEntity<Map<String, Object>> checkUserId(@RequestBody Customer customer) {
		String message = customerService.forgotCustomerPassword(customer.getCustomerUsername());
		boolean idExists = message.contains("ID exists");
		return new ResponseEntity<>(Map.of("message", message, "idExists", idExists), HttpStatus.OK);
	}

	// Update Customer Password (PUT)
	@PutMapping("/forgot-password/update")
	public ResponseEntity<Map<String, String>> updatePassword(@RequestBody Map<String, Object> payload) {
		Integer customerUsername = (Integer) payload.get("customerUsername");
		String customerPassword = (String) payload.get("customerPassword");
		String message = customerService.updateCustomerPassword(customerUsername, customerPassword);
		return new ResponseEntity<>(Map.of("message", message), HttpStatus.OK);
	}
}
