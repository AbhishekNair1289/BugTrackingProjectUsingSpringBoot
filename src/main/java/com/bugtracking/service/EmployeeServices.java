package com.bugtracking.service;

import java.util.List;
import java.util.Optional;

import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.exception.DuplicateRecordException;
import com.bugtracking.exception.InvalidDetailsException;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;

public interface EmployeeServices {
	    
	    public String createEmployee(EmployeeEntity employeeEntity) throws RegistrationException, RecordNotFoundException, DuplicateRecordException, InvalidDetailsException;
	    
	    public String updateEmployee(EmployeeEntity employeeEntity) throws RegistrationException, RecordNotFoundException;
	    
	    public String deleteEmployee(String emailid)throws RegistrationException, RecordNotFoundException;
	    
	    public Optional<EmployeeEntity> getEmployeeById(String emailid)throws RegistrationException, RecordNotFoundException;
	    
	    public List<EmployeeEntity> getAllEmployees()throws RegistrationException, RecordNotFoundException;
	}

