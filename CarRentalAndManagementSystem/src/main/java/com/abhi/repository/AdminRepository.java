package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.abhi.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("SELECT a FROM Admin a WHERE a.adminUsername = ?1 AND a.adminPassword = ?2")
	public Admin adminLoginWithUsernameAndPassword(Integer adminUsername, String adminPassword);
}
