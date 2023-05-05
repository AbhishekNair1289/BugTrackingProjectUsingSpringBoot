package com.bugtracking.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.dao.AdminDao;
import com.bugtracking.dao.Employeedao;
import com.bugtracking.entity.AdminEntity;
import com.bugtracking.entity.AdminRegisterEntity;
import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.entity.EmployeeRegistrationEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	Employeedao emprepo;

	@Autowired
	AdminDao adminrepo;

	public EmployeeEntity authenticateEmployee1(String email, String epassword)
			throws RegistrationException, RecordNotFoundException {
		// condition for improper details
		if (email.equals("") || epassword == null) {
			throw new RegistrationException("Invalid Details! please enter correct details");
		} else {
			Optional<EmployeeEntity> user = emprepo.findById(email);
			// condition if record not exists in database
			if (!user.isPresent())
				throw new RecordNotFoundException("No record exists for given user");
			// condition for if record present and password does not matches
			if (user.isPresent() && !(user.get().getEpassword().equals(epassword)))
				throw new RegistrationException("password does not matches");
			return user.get();
		}
	}
	
	public String authenticateEmployee(String email, String epassword)
			throws RegistrationException, RecordNotFoundException {
		// condition for improper details
		if (email.equals("") || epassword == null) {
			throw new RegistrationException("Invalid Details! please enter correct details");
		} else {
			Optional<EmployeeEntity> user = emprepo.findById(email);
			// condition if record not exists in database
			if (!user.isPresent())
				throw new RecordNotFoundException("No record exists for given user");
			// condition for if record present and password does not matches
			if (user.isPresent() && !(user.get().getEpassword().equals(epassword)))
				throw new RegistrationException("password does not matches");
			return "\t\t\tEmployee Login Success\n\n\n\t\t\tWelcome "+user.get().getEmpNname();
		}
	}

	@Override
	public List<EmployeeEntity> getAllEmployeeDetails() {
		return emprepo.findAll();
	}


	@Override
	public List<AdminEntity> getAllAdminDetails() {
		return adminrepo.findAll();
	}

	@Override
	public AdminEntity authenticateAdmin1(String adminEmail, String password)
			throws RegistrationException, RecordNotFoundException {
		
		// condition for improper details
				if (adminEmail.equals("") || password == null) {
					throw new RegistrationException("Invalid Details! please enter correct details");
				} else {
					Optional<AdminEntity> user = adminrepo.findById(adminEmail);
					// condition if record not exists in database
					if (!user.isPresent())
						throw new RecordNotFoundException("No record exists for given Admin");
					// condition for if record present and password does not matches
					if (user.isPresent() && !(user.get().getPassword().equals(password)))
						throw new RegistrationException("password does not matches");
					return user.get();
				}
	}
	@Override
	public String authenticateAdmin(String adminEmail, String password)
			throws RegistrationException, RecordNotFoundException {
		
		// condition for improper details
				if (adminEmail.equals("") || password == null) {
					throw new RegistrationException("Invalid Details! please enter correct details");
				} else {
					Optional<AdminEntity> user = adminrepo.findById(adminEmail);
					// condition if record not exists in database
					if (!user.isPresent())
						throw new RecordNotFoundException("No record exists for given Admin");
					// condition for if record present and password does not matches
					if (user.isPresent() && !(user.get().getPassword().equals(password)))
						throw new RegistrationException("password does not matches");
					return "\t\t\tAdmin Login Success\n\n\n\t\t\tWelcome "+user.get().getName();
				}
	}

}
