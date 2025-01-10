package com.abhi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.models.Admin;
import com.abhi.repository.AdminRepository;

@Service
public class AdminServiceImplementation implements IAdminService {

	@Autowired
	private AdminRepository repository;

	@Override
	public String registerAdmin(Admin admin) {
		if (admin == null) {
			throw new IllegalArgumentException("Please provide valid data.");
		}
		if (repository.existsById(admin.getAdminUsername())) {
			return "Admin with username " + admin.getAdminUsername() + " already exists.";
		}
		Admin savedAdmin = repository.save(admin);
		return savedAdmin.getFirstName() + " registered with username " + savedAdmin.getAdminUsername();
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		if (admin.getAdminUsername() == null || admin.getAdminPassword() == null) {
			throw new IllegalArgumentException("Username or password cannot be null.");
		}

		Admin existingUser = repository.adminLoginWithUsernameAndPassword(admin.getAdminUsername(),
				admin.getAdminPassword());

		if (existingUser == null) {
			throw new IllegalArgumentException("Invalid username or password.");
		}

		return existingUser;
	}

	@Override
	public Admin fatchAdminDetailsById(int id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Admin ID does not exist."));
	}

	@Override
	public String updateAdminDetails(Admin admin) {
		if (repository.existsById(admin.getAdminUsername())) {
			Admin updatedAdmin = repository.save(admin);
			return updatedAdmin.getFirstName() + "'s profile updated successfully.";
		}
		return "Admin details not found.";
	}

	@Override
	public String forgotAdminPassword(Integer adminUsername) {
		if (repository.existsById(adminUsername)) {
			return "ID exists. Please enter a new password.";
		}
		return "Admin ID not found.";
	}

	@Override
	public String updateAdminPassword(Integer adminUsername, String newPassword) {
		Optional<Admin> adminOptional = repository.findById(adminUsername);
		if (adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			admin.setAdminPassword(newPassword);
			repository.save(admin);
			return "Password updated successfully for username: " + admin.getFirstName();
		}
		return "Failed to update password. Admin ID not found.";
	}

	

}
