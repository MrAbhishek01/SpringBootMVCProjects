package com.abhi.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

	private Integer customerUsername;

	private String customerPassword;

	private String firstName;

	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private String gender;

	private String address;

	private String emailId;
	private long phoneNumber;

}
