package com.abhi.service;

import java.util.List;

import com.abhi.entity.Student;

public interface IStudentService {

	public List<Student> showAllDetails();
	public String addStudent(Student student);
	public String editStudentDetails(Student student);
	public Student fatchEmployeeById(int id);
	public String deleteEmployeeDetails(int id);
	public List<Student> dynamicSearch(Student student);
}
