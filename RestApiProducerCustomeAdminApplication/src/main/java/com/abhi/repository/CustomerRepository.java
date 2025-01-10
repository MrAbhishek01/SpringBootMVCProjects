package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.abhi.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.customerUsername = ?1 AND c.customerPassword = ?2")
	public Customer customerLoginWithUsernameAndPassword(Integer customerUsername, String customerPassword);
}
