package com.bugtracking.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.entity.AdminRegisterEntity;
import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.entity.EmployeeRegistrationEntity;
import com.bugtracking.exception.DuplicateRecordException;
import com.bugtracking.exception.InvalidDetailsException;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;
import com.bugtracking.service.LoginServiceImpl;
import com.bugtracking.service.LogoutServiceImpl;



@RestController
@RequestMapping("/bugtracker")
public class LogoutController {
	@Autowired
    private LogoutServiceImpl logo;
    
	public static Logger logs = Logger.getLogger(EmployeeEntity.class.getName());
    
	
    // USED TO LOGOUT
    @PostMapping("/employee/logout")
    public ResponseEntity<String> logout(@RequestBody EmployeeEntity userbasic) throws RecordNotFoundException{
        EmployeeEntity userRegis = logo.logout(userbasic);
        logs.info("Logged out succesfully");
        return new ResponseEntity("Logout Successful", HttpStatus.OK);

 

    }

}
