package com.bugtracking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.entity.AdminEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;
import com.bugtracking.service.AdminServiceImpl;


@RestController
@RequestMapping("/bugtracker")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	
    
	@PostMapping("/admin/registration")   //http://localhost:4321/bugtracker/admin/registration
	public String createAdmin(@RequestBody AdminEntity admin) throws RegistrationException, RecordNotFoundException {
		return adminService.createAdmin(admin);
	}

	@GetMapping("/admin/{emailid}") //http://localhost:4321/bugtracker/admin/{email}
	public AdminEntity getadminById(@PathVariable String emailid) throws RecordNotFoundException {
		return adminService.getByAdminId(emailid);
	}



}
