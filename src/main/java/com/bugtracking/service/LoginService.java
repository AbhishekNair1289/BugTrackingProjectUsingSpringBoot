package com.bugtracking.service;

import java.util.List;

import com.bugtracking.entity.AdminEntity;
import com.bugtracking.entity.AdminRegisterEntity;
import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.entity.EmployeeRegistrationEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;



public interface LoginService {
	public String authenticateEmployee(String userEmail,String password) throws RegistrationException, RecordNotFoundException ;
	public EmployeeEntity authenticateEmployee1(String userEmail,String password) throws RegistrationException, RecordNotFoundException ;
	   public List<EmployeeEntity> getAllEmployeeDetails();
	   public String authenticateAdmin(String adminEmail,String password) throws RegistrationException, RecordNotFoundException;
	   public AdminEntity authenticateAdmin1(String adminEmail,String password) throws RegistrationException, RecordNotFoundException;
		   public List<AdminEntity> getAllAdminDetails();

}
