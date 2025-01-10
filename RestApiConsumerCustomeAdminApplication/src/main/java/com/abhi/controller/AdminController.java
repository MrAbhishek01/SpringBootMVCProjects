package com.abhi.controller;

import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.abhi.models.Admin;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	private static final String BASE_URL = "http://localhost:8089/RestApiProducerCustomeAdminApplication/api/admin";

	@GetMapping("/login")
	public String loginAdminPage(@ModelAttribute Admin admin) {
		return "admin/adminLogin";
	}

	@PostMapping("/login")
	public String loginAdminSuccess(@ModelAttribute Admin admin, Map<String, Object> map, HttpSession session) {
		String url = BASE_URL + "/login";
		try {
			Map<String, Object> loginResult = restTemplate.postForObject(url, admin, Map.class);
			session.setAttribute("loggedInAdmin", loginResult.get("admin"));
			map.put("message", "Login successful!");
			return "admin/insideAdminLoginPage";
		} catch (IllegalArgumentException e) {
			map.put("message", e.getMessage());
			return "admin/adminLogin";
		}
	}

	@GetMapping("/adminRegisterPage")
	public String showAdminRegisterPage(@ModelAttribute Admin admin) {
		return "admin/registerAdmin";
	}

	@PostMapping("/adminRegisterPage")
	public String registerAdmin(@ModelAttribute Admin admin, RedirectAttributes attributes) {
		String url = BASE_URL + "/register";
		String registerAdmin = restTemplate.postForObject(url, admin, String.class);
		attributes.addFlashAttribute("message", registerAdmin);
		return "redirect:/admin/login";
	}

	@GetMapping("/logout")
	public String adminLogout(HttpSession session) {
		String url = BASE_URL + "/logout";
		restTemplate.postForObject(url, null, String.class);
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/dashboard")
	public String showAdminDashboard(HttpSession session, Map<String, Object> map) {
		Admin loggedInAdmin = (Admin) session.getAttribute("loggedInAdmin");
		if (loggedInAdmin == null) {
			return "redirect:/admin/login";
		}
		map.put("message", "Welcome " + loggedInAdmin.getFirstName());
		return "admin/insideAdminLoginPage";
	}

	@GetMapping("/editAdminProfile")
	public String editAdminProfile(@RequestParam Integer id, @ModelAttribute Admin admin, HttpSession session) {
		String url = BASE_URL + "/profile/" + id;
		Admin fetchedAdminDetails = restTemplate.getForObject(url, Admin.class);
		BeanUtils.copyProperties(fetchedAdminDetails, admin);
		session.setAttribute("loggedInAdmin", admin);
		return "admin/adminEditPage";
	}

	@PostMapping("/editAdminProfile")
	public String updateAdminProfile(@ModelAttribute Admin admin, Map<String, Object> attributes, HttpSession session) {
		String url = BASE_URL + "/profile";
		restTemplate.put(url, admin);
		attributes.put("message", "Profile updated successfully!");
		session.setAttribute("loggedInAdmin", admin);
		return "admin/insideAdminLoginPage";
	}

	@GetMapping("/forgot-password")
	public String forgotPasswordPage(@ModelAttribute Admin admin) {
		return "admin/forgotAdminPasswordPage";
	}

	@PostMapping("/forgot-password")
	public String checkUserId(@ModelAttribute Admin admin, Map<String, Object> map) {
		String url = BASE_URL + "/forgot-password";
		try {
			Map<String, Object> response = restTemplate.postForObject(url, admin, Map.class);
			map.put("message", response.get("message"));
			map.put("idExists", response.get("idExists"));
			return "admin/forgotAdminPasswordPage";
		} catch (Exception e) {
			map.put("message", "Error: " + e.getMessage());
			return "admin/forgotAdminPasswordPage";
		}
	}

	@PostMapping("/update-password")
	public String updatePassword(@RequestParam("adminUsername") Integer adminUsername,
			@RequestParam("adminPassword") String adminPassword, RedirectAttributes attributes) {
		String url = BASE_URL + "/update-password";
		try {
			Map<String, String> request = Map.of("adminUsername", adminUsername.toString(), "adminPassword",
					adminPassword);
			restTemplate.put(url, request);
			attributes.addFlashAttribute("message", "Password updated successfully!");
			return "redirect:/admin/login";
		} catch (Exception e) {
			attributes.addFlashAttribute("message", "Error: " + e.getMessage());
			return "redirect:/admin/forgot-password";
		}
	}

}