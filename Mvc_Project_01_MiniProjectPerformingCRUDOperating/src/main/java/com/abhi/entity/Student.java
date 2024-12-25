package com.abhi.entity;

import java.util.Date; 
import org.springframework.format.annotation.DateTimeFormat;
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
public class Student {

	@Id
	@SequenceGenerator(name = "student_gen", sequenceName = "student_seq_gen", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "student_gen", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(length = 20)
	private String name;

	@Column(length = 30)
	private String email;

	private Long contactNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joiningDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date passoutDate;
}
