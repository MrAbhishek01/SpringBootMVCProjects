package com.abhi.service;

import java.util.List;
import com.abhi.entity.Employee;

public interface IEmployeeService {
	public List<Employee> showReport();

	public String addEmployee(Employee employee);

	public Employee fatchEmployeeByID(int id);

	public String updateEmployeeRecord(Employee employee);

	public String deleteById(int id);

	public List<Employee> searchEmployeeReportWithDyanmicSearch(Employee employee);

}
