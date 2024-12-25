package com.abhi.entity;

import java.util.Date; 

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name ="Student1")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "update student1 set status = 'inactive' where id=?")
@SQLDelete(sql = "UPDATE STUDENT1 SET STATUS = 'INACTIVE' WHERE ID=?")
@SQLRestriction(value = "STATUS<>'INACTIVE' ")
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

	private String status = "active";
}
