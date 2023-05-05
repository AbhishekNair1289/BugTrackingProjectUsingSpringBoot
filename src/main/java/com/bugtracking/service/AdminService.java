package com.bugtracking.service;


import java.util.Optional;

import com.bugtracking.entity.AdminEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;


public interface AdminService {

	public String createAdmin(AdminEntity admin) throws RegistrationException, RecordNotFoundException;
    
    public AdminEntity getByAdminId(String emailid) throws RecordNotFoundException;
    
}
