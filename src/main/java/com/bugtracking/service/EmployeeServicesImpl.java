package com.bugtracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugtracking.dao.Employeedao;
import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.exception.DuplicateRecordException;
import com.bugtracking.exception.InvalidDetailsException;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;

@Service
@Transactional
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	Employeedao employeeDao;

	@Override
	public String createEmployee(EmployeeEntity employeeEntity) throws RegistrationException, RecordNotFoundException, DuplicateRecordException, InvalidDetailsException{
		employeeDao.save(employeeEntity);
		return "Employee Created Successfully";
	}

	@Override
	public String updateEmployee(EmployeeEntity employeeEntity) throws RegistrationException, RecordNotFoundException{
		employeeDao.save(employeeEntity);
		return "Employee Updated Successfully";
	}

	@Override
	public String deleteEmployee(String emailid)throws RegistrationException, RecordNotFoundException {
		employeeDao.deleteById(emailid);
		return "Employee Deleted Successfully";
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeById(String emailid) throws RegistrationException, RecordNotFoundException{
		return employeeDao.findById(emailid);
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() throws RegistrationException, RecordNotFoundException{
		return employeeDao.findAll();
	}
}
