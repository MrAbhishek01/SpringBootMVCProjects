package com.abhi.entity;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_value_gen", initialValue = 5000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empId;

	@Column(length = 20)
	private String empName;

	@Column(length = 20)
	private String empEmail;

	private Double empSalary;
	@Column(length = 20)

	private String empDepartment = "Finance";

}
