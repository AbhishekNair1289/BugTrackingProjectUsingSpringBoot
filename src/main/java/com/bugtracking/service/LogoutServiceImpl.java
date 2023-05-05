package com.bugtracking.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.dao.Employeedao;
import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.exception.RecordNotFoundException;

@Service
@Transactional
public class LogoutServiceImpl implements LogoutService{

	@Autowired
    private Employeedao employeerepo;
    // USED TO LOGOUT
        @Override
        public EmployeeEntity logout(EmployeeEntity userbasic)throws RecordNotFoundException {
            
            Optional<EmployeeEntity> userbasics = employeerepo.findById(userbasic.getEmail());
            if (!userbasics.isPresent()) 
            {
                return null;
            } else
                return userbasics.get();
        }
}
