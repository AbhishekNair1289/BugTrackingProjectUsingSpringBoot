package com.bugtracking.service;

import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.exception.RecordNotFoundException;

public interface LogoutService {
	public EmployeeEntity logout(EmployeeEntity userbasic) throws RecordNotFoundException;
    

}
