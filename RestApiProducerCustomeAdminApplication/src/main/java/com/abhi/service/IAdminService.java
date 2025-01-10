package com.abhi.service;

import java.util.List;

import com.abhi.models.Admin;

public interface IAdminService {

	public String registerAdmin(Admin admin);

	public Admin loginAdmin(Admin admin);

	public Admin fatchAdminDetailsById(int id);

	public String updateAdminDetails(Admin admin);

	public String  forgotAdminPassword(Integer no) ;
	
	public String updateAdminPassword(Integer id, String newPassword);
	
	
}
