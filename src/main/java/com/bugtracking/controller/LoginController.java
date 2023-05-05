package com.bugtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.entity.AdminEntity;
import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.exception.DuplicateRecordException;
import com.bugtracking.exception.InvalidDetailsException;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;
import com.bugtracking.service.LoginServiceImpl;

@RestController
@RequestMapping("/bugtracker")
public class LoginController {
	@Autowired
	LoginServiceImpl loginService;


	@GetMapping("/employee/login/{userEmail}/{password}")  //http://localhost:4321/bugtracker/employeelogin/{userEmail}/{password}
	public ResponseEntity<Object> verifyUser(@PathVariable("userEmail") String userEmail,
			@PathVariable("password") String password)
			throws RegistrationException, RecordNotFoundException, DuplicateRecordException {
		EmployeeEntity empUser = loginService.authenticateEmployee1(userEmail, password);
		// Log.info(" user signin");
		EntityModel<EmployeeEntity> resource = EntityModel.of(empUser);

		return new ResponseEntity<Object>(resource, HttpStatus.OK);
	}
	
//	@GetMapping("/employeelogin/{userEmail}/{password}")  //http://localhost:4321/bugtracker/employeelogin/{userEmail}/{password}
//	public ResponseEntity<Object> verifyUser(@PathVariable("userEmail") String userEmail,
//			@PathVariable("password") String password)
//			throws RegistrationException, RecordNotFoundException, DuplicateRecordException {
//		String empUser = loginService.authenticateEmployee(userEmail, password);
//		// Log.info(" user signin");
////		EntityModel<EmployeeEntity> resource = EntityModel.of(empUser);
//
//		return new ResponseEntity<Object>(empUser, HttpStatus.OK);
//	}

	@GetMapping("/admin/login/{adminEmail}/{password}")//http://localhost:4321/bugtracker/adminlogin/{adminEmail}/{password}
	public ResponseEntity<Object> adminVerfication(@PathVariable("adminEmail") String adminEmail,
			@PathVariable("password") String password) 
					throws RegistrationException, RecordNotFoundException,
			DuplicateRecordException, InvalidDetailsException {
		AdminEntity admin = loginService.authenticateAdmin1(adminEmail, password);// Log.info("admin sign in");
		EntityModel<AdminEntity> resource = EntityModel.of(admin);

		return new ResponseEntity<Object>(resource, HttpStatus.OK);
	}
	
//	@GetMapping("/adminlogin/{adminEmail}/{password}")//http://localhost:4321/bugtracker/adminlogin/{adminEmail}/{password}
//	public ResponseEntity<Object> adminVerfication(@PathVariable("adminEmail") String adminEmail,
//			@PathVariable("password") String password) 
//					throws RegistrationException, RecordNotFoundException,
//			DuplicateRecordException, InvalidDetailsException {
//		String admin = loginService.authenticateAdmin(adminEmail, password);// Log.info("admin sign in");
////		EntityModel<AdminEntity> resource = EntityModel.of(admin);
//
//		return new ResponseEntity<Object>(admin, HttpStatus.OK);
//	}


}
