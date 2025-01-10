package com.abhi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.models.Admin;
import com.abhi.models.Customer;
import com.abhi.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements ICustomerService {
	@Autowired
	private CustomerRepository repository;

	@Override
	public String registerCustomer(Customer customer) {

		if (customer == null) {
			throw new IllegalArgumentException("Please provide valid data.");
		}
		if (repository.existsById(customer.getCustomerUsername())) {
			return "Customer with username " + customer.getCustomerUsername() + " already exists.";
		}
		Customer savedCustomer = repository.save(customer);
		return savedCustomer.getFirstName() + " registered with username " + savedCustomer.getCustomerUsername();
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		Integer customerUsername = customer.getCustomerUsername();
		if (customer.getCustomerUsername() == null || customer.getCustomerPassword() == null) {
			throw new IllegalArgumentException("Username or password cannot be null.");
		}
		repository.findById(customerUsername).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
		Customer existingUser = repository.customerLoginWithUsernameAndPassword(customer.getCustomerUsername(),
				customer.getCustomerPassword());
		if (existingUser == null) {
			throw new IllegalArgumentException("Invalid username or password.");
		}
		return existingUser; // Return Admin object, not String
	}

	@Override
	public Customer fatchCustomerDetailsById(int id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not exist"));
	}

	@Override
	public String updateCustomerDetails(Customer customer) {
		Optional<Customer> byId = repository.findById(customer.getCustomerUsername());
		if (byId.isPresent()) {
			Customer save = repository.save(customer);
			return customer.getFirstName() + " profile updated successfully";
		}
		return "details not found";
	}

	@Override
	public String forgotCustomerPassword(Integer customerUsername) {
		if (repository.existsById(customerUsername)) {
			return "ID exists. Please enter a new password.";
		} else {
			return "Customer ID not found.";
		}
	}

	@Override
	public String updateCustomerPassword(Integer customerUsername, String newPassword) {
		Optional<Customer> customerOptional = repository.findById(customerUsername);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customer.setCustomerPassword(newPassword);
			Customer save = repository.save(customer);
			return "Password updated successfully for username: " + save.getFirstName();
		}
		return "Failed to update password. Customer ID not found.";
	}
}
