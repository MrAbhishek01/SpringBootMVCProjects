package com.abhi.service;

import com.abhi.models.Customer;

public interface ICustomerService {
	public String registerCustomer(Customer customer);

	public Customer loginCustomer(Customer customer);

	public Customer fatchCustomerDetailsById(int id);

	public String updateCustomerDetails(Customer customer);

	public String forgotCustomerPassword(Integer no);

	public String updateCustomerPassword(Integer id, String newPassword);

}
