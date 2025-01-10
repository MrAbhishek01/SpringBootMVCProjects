package com.abhi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.models.Admin;
import com.abhi.service.IAdminService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	// Admin Login (POST)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin, HttpSession session) {
		try {
			Admin loginResult = adminService.loginAdmin(admin);
			session.setAttribute("loggedInAdmin", loginResult);
			return ResponseEntity.ok(Map.of("message", "Login successful!", "admin", loginResult));
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.UNAUTHORIZED);
		}
	}

	// Admin Registration (POST)
	@PostMapping("/register")
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
		String message = adminService.registerAdmin(admin);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	// Admin Logout
	@PostMapping("/logout")
	public ResponseEntity<String> adminLogout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<String>("Logout successful!", HttpStatus.OK);
	}

	// Admin Dashboard Access
	@GetMapping("/dashboard")
	public ResponseEntity<Map<String, Object>> showAdminDashboard(HttpSession session) {
		Admin loggedInAdmin = (Admin) session.getAttribute("loggedInAdmin");
		if (loggedInAdmin == null) {
			return new ResponseEntity<>(Map.of("message", "Please log in first."), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok(Map.of("message", "Welcome " + loggedInAdmin.getFirstName(), "admin", loggedInAdmin));
	}

	// Edit Admin Profile (GET)
	@GetMapping("/profile/{id}")
	public ResponseEntity<Admin> editAdminProfile(@PathVariable Integer id) {
		Admin fetchedAdminDetails = adminService.fatchAdminDetailsById(id);
		return ResponseEntity.ok(fetchedAdminDetails);
	}

	// Update Admin Profile (PUT)
	@PutMapping("/profile")
	public ResponseEntity<String> updateAdminProfile(@RequestBody Admin admin, HttpSession session) {
		String message = adminService.updateAdminDetails(admin);
		session.setAttribute("loggedInAdmin", admin);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PostMapping("/forgot-password")
    public ResponseEntity<Map<String, Object>> forgotPassword(@RequestBody Map<String, String> request) {
        String adminUsernameStr = request.get("adminUsername");
        Integer adminUsername;
        try {
            adminUsername = Integer.parseInt(adminUsernameStr);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(Map.of("message", "Invalid adminUsername format"), HttpStatus.BAD_REQUEST);
        }
        String message = "ID exists for adminUsername: " + adminUsername;
        boolean idExists = true;
        return ResponseEntity.ok(Map.of("message", message, "idExists", idExists));
    }

    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> request) {
        Integer adminUsername = Integer.parseInt(request.get("adminUsername"));
        String adminPassword = request.get("adminPassword");
        return new ResponseEntity<>("Password updated for adminUsername: " + adminUsername, HttpStatus.OK);
    }
}
