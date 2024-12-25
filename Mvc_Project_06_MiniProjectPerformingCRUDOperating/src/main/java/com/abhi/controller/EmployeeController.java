package com.abhi.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.abhi.entity.Employee;
import com.abhi.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/")
	public String showHomePages() {
		return "welcome";
	}

	@GetMapping("/report")
	public String getReport(Map<String, Object> map, @ModelAttribute Employee employee) {
		try {
			List<Employee> reportList = employeeService.showReport();
			map.put("reportList", reportList);
			return "showReport";
		} catch (Exception e) {
			map.put("msg", "Error fetching report: " + e.getMessage());
			return "error";
		}
	}

	@GetMapping("/register")
	public String showRegistrationPage(@ModelAttribute Employee employee) {
		return "registration";
	}

	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee employee, RedirectAttributes attributes) {
		try {
			String result = employeeService.addEmployee(employee);
			attributes.addFlashAttribute("message", "Employee registered successfully with ID: " + result);
			return "redirect:report";
		} catch (Exception e) {
			attributes.addFlashAttribute("msg", "Error during registration: " + e.getMessage());
			return "error";
		}
	}

	@GetMapping("/edit")
	public String showEditPages(@RequestParam("no") int no, @ModelAttribute Employee employee) {
		Employee fatchEmployeeByID = employeeService.fatchEmployeeByID(no);
		BeanUtils.copyProperties(fatchEmployeeByID, employee);
		return "employee_edit";
	}

	@PostMapping("/edit")
	private String updateRecourd(@ModelAttribute Employee employee, RedirectAttributes attributes) {
		try {
			String updateEmployeeRecord = employeeService.updateEmployeeRecord(employee);
			attributes.addFlashAttribute("message", updateEmployeeRecord);
			return "redirect:report";
		} catch (Exception e) {
			attributes.addAttribute("msg", e.getMessage());
			return "error";

		}
	}

	@GetMapping("/delete")
	private String deleteRecourd(@RequestParam("no") int no, Map<String, Object> map) {
		try {
			String deleteById = employeeService.deleteById(no);
			map.put("message", deleteById);
			return "forward:report";
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			return "error";
		}

	}

	@PostMapping("/search")
	public String searchRecourd(@ModelAttribute Employee employee, Map<String, Object> map) {
		try {

			List<Employee> searchEmployeeReportWithDyanmicSearch = employeeService
					.searchEmployeeReportWithDyanmicSearch(employee);
			map.put("reportList", searchEmployeeReportWithDyanmicSearch);

			return "showReport";

		} catch (Exception e) {
			map.put("msg", e.getMessage());
			return "showReport";
		}

	}

}
