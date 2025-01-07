package com.abhi.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abhi.models.Admin;
import com.abhi.service.IAdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private IAdminService adminService;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/adminLoginPage")
	public String loginAdminPage(@ModelAttribute Admin admin) {
		return "adminLogin";
	}

	@PostMapping("/adminLoginPage")
	public String loginAdminSuccess(@ModelAttribute Admin admin, Map<String, Object> map, HttpSession session) {
		try {
			Admin loginResult = adminService.loginAdmin(admin);
			session.setAttribute("loggedInAdmin", loginResult);
			map.put("message", "Login successful!");
			return "insideAdminLoginPage";
		} catch (IllegalArgumentException e) {
			map.put("message", e.getMessage());
			return "adminLogin";
		}
	}

	@GetMapping("/adminRegisterPage")
	public String showAdminRegisterPage(@ModelAttribute Admin admin) {
		return "registerAdmin";
	}

	@PostMapping("/adminRegisterPage")
	public String registerAdmin(@ModelAttribute Admin admin, RedirectAttributes attributes) {

		String registerAdmin = adminService.registerAdmin(admin);
		attributes.addFlashAttribute("message", registerAdmin);
		return "redirect:/adminLoginPage";
	}

	@GetMapping("/logout")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/editAdminProfile")
	public String editAdminProfile(@RequestParam Integer no, @ModelAttribute Admin admin, HttpSession session) {
		Admin fatchAdminDetailsById = adminService.fatchAdminDetailsById(no);
		BeanUtils.copyProperties(fatchAdminDetailsById, admin);
		session.setAttribute("loggedInAdmin", admin);
		return "adminEditPage";
	}

	@PostMapping("editAdminProfile")
	public String updateAdminProfile(@ModelAttribute Admin admin, Map<String, Object> attributes, HttpSession session) {
		// session.setAttribute("loggedInAdmin", admin);
		String updateAdminDetails = adminService.updateAdminDetails(admin);
		attributes.put("massage", updateAdminDetails);
		return "insideAdminLoginPage";
	}

	// forgot Password

	@GetMapping("/forgotAdminPassword")
	public String forgotPasswordPage(@ModelAttribute Admin admin) {
		return "forgotAdminPasswordPage"; // JSP name
	}

	@PostMapping("/checkUserId")
	public String checkUserId(@ModelAttribute("admin") Admin admin, Map<String, Object> map) {
		String message = adminService.forgotAdminPassword(admin.getAdminUsername());
		boolean idExists = message.contains("ID exists");
		map.put("message", message);
		map.put("idExists", idExists);
		map.put("admin", admin);
		return "forgotAdminPasswordPage";
	}

	@PostMapping("/updatePassword")
	public String updatePassword(@RequestParam("adminUsername") Integer adminUsername,
			@RequestParam("adminPassword") String adminPassword, RedirectAttributes attributes) {
		String message = adminService.updateAdminPassword(adminUsername, adminPassword);
		attributes.addFlashAttribute("message", message);
		return "redirect:/adminLoginPage";
	}
}