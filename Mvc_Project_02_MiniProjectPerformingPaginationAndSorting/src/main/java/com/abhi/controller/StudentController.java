package com.abhi.controller;

import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.abhi.entity.Student;
import com.abhi.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	private IStudentService service;

	@GetMapping("/")
	public String showHomePages() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showReport(Map<String, Object> map, @ModelAttribute Student student,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		try {
			Page<Student> showAllDetails = service.showAllDetails(pageable);
			map.put("pageData", showAllDetails);
			return "showReport";
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			return "error";
		}
	}

	@GetMapping("/addStudentData")
	public String showStudentRegistrationForm(@ModelAttribute Student student) {

		return "studentRegistration";
	}

	@PostMapping("/addStudentData")
	public String processStudentData(@ModelAttribute Student student, RedirectAttributes attributes) {
		try {
			String studentId = service.addStudent(student);
			attributes.addFlashAttribute("msg", studentId);
			return "redirect:report";
		} catch (Exception e) {
			attributes.addAttribute("msg", e.getMessage());
			return "error";
		}
	}

	@GetMapping("/edit")
	public String showeditStudent(@RequestParam("no") int no, @ModelAttribute Student student) {
		Student fatchEmployeeById = service.fatchEmployeeById(no);
		BeanUtils.copyProperties(fatchEmployeeById, student);
		return "editStudent";
	}

	@PostMapping("/edit")
	public String editStudent(@ModelAttribute Student student, RedirectAttributes attributes) {

		String editStudentDetails = service.editStudentDetails(student);
		attributes.addFlashAttribute("msg", editStudentDetails);
		return "redirect:report";

	}

	@GetMapping("/delete")
	public String deleteStudentRecourd(@RequestParam("no") int no, Map<String, Object> map) {
		try {
			String deleteEmployeeDetails = service.deleteEmployeeDetails(no);
			map.put("msg", deleteEmployeeDetails);
			return "forward:report";
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			return "error";
		}
	}

	/*@PostMapping("/Search")
	public String dynamicSearchStudentDetails(@ModelAttribute Student student, Map<String, Object> map) {
		try {
			List<Student> searchResults = service.dynamicSearch(student);
			map.put("reportList", searchResults);
			return "showReport";
		} catch (Exception e) {
			map.put("msg", "Error during search: " + e.getMessage());
			return "error";
		}
	}*/
}
