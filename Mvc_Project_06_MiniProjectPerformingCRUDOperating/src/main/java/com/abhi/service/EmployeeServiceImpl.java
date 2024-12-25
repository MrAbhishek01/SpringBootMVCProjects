package com.abhi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.abhi.entity.Employee;
import com.abhi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> showReport() {
		List<Employee> all = employeeRepository.findAll();
		all.sort((o1, o2) -> o1.getEmpName().compareTo(o2.getEmpName()));
		return all;
	}

	@Override
	public String addEmployee(Employee employee) {
		Employee save = employeeRepository.save(employee);
		return "Employee Details inserted with " + save.getEmpId();
	}

	@Override
	public Employee fatchEmployeeByID(int id) {

		return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public String updateEmployeeRecord(Employee employee) {
		Optional<Employee> byId = employeeRepository.findById(employee.getEmpId());
		if (byId.isPresent()) {
			employeeRepository.save(employee);
			return employee.getEmpId() + " updated Successfully";
		}
		return employee.getEmpId() + " employee not found in the dataBase";
	}

	@Override
	public String deleteById(int id) {
		Optional<Employee> byId = employeeRepository.findById(id);
		if (byId.isPresent()) {
			employeeRepository.deleteById(id);
			return id + " record deleted successfully";
		} else {
			return id + " record not found for the Deleation";
		}
	}

	@Override
	public List<Employee> searchEmployeeReportWithDyanmicSearch(Employee employee) {

		if (employee.getEmpName() == null || employee.getEmpName().isEmpty()) {
			employee.setEmpName(null);
		}
		if (employee.getEmpEmail() == null || employee.getEmpEmail().isEmpty()) {
			employee.setEmpEmail(null);
		}
		if (employee.getEmpDepartment() == null || employee.getEmpDepartment().isEmpty()) {
			employee.setEmpDepartment(null);
		}
		if (employee.getEmpSalary() == null || employee.getEmpSalary() <= 0) {
			employee.setEmpSalary(null);
		}

		Example<Employee> example = Example.of(employee);
		return employeeRepository.findAll(example);
	}
}