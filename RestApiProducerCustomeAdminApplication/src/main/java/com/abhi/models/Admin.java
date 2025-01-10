package com.abhi.models;

import java.util.Date; 

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	private Integer adminUsername;
	@Column(length = 20)
	private String adminPassword;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 20)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	@Column(length = 20)
	private String gender;
	@Column(length = 20)
	private String address;
	@Column(length = 20)
	private String emailId; 
	private long phoneNumber;

}
