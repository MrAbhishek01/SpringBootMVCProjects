package com.abhi.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.abhi.entity.Student;

public interface IStudentService {

	public Page<Student> showAllDetails(Pageable pageable);
	public String addStudent(Student student);
	public String editStudentDetails(Student student);
	public Student fatchEmployeeById(int id);
	public String deleteEmployeeDetails(int id);
	//public List<Student> dynamicSearch(Student student);
}
