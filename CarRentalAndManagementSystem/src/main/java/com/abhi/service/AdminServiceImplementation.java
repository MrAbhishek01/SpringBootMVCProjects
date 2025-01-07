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
		Admin save = repository.save(admin);
		return save.getFirstName() + " registered with username " + save.getAdminUsername();
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		Integer adminUsername = admin.getAdminUsername();
		if (admin.getAdminUsername() == null || admin.getAdminPassword() == null) {
			throw new IllegalArgumentException("Username or password cannot be null.");
		}

		repository.findById(adminUsername).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
		Admin existingUser = repository.adminLoginWithUsernameAndPassword(admin.getAdminUsername(),
				admin.getAdminPassword());
		if (existingUser == null) {
			throw new IllegalArgumentException("Invalid username or password.");
		}
		return existingUser; // Return Admin object, not String
	}

	@Override
	public Admin fatchAdminDetailsById(int id) {

		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not exist"));
	}

	@Override
	public String updateAdminDetails(Admin admin) {
		Optional<Admin> byId = repository.findById(admin.getAdminUsername());
		if (byId.isPresent()) {
			Admin save = repository.save(admin);
			return admin.getFirstName() + " profile updated successfully";
		}
		return "details not found";
	}

	public String forgotAdminPassword(Integer adminUsername) {

		if (repository.existsById(adminUsername)) {
			return "ID exists. Please enter a new password.";
		} else {
			return "Admin ID not found.";
		}
	}

	@Override
	public String updateAdminPassword(Integer adminUsername, String newPassword) {
		Optional<Admin> adminOptional = repository.findById(adminUsername);
		if (adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			admin.setAdminPassword(newPassword);
			Admin save = repository.save(admin);
			return "Password updated successfully for username: " + save.getFirstName();
		}
		return "Failed to update password. Admin ID not found.";
	}
}