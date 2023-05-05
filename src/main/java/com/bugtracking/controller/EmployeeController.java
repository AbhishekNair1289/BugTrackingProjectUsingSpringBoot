package com.bugtracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.exception.DuplicateRecordException;
import com.bugtracking.exception.InvalidDetailsException;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;
import com.bugtracking.service.EmployeeServices;
import com.bugtracking.service.EmployeeServicesImpl;


@RestController
@RequestMapping("/bugtracker")
public class EmployeeController {
    
    @Autowired
    private EmployeeServicesImpl employeeService;

    @PostMapping("/employee/register")  //http://localhost:4321/bugtracker/employee/register
    public String createEmployee(@RequestBody EmployeeEntity employeeEntity) throws RegistrationException, RecordNotFoundException, DuplicateRecordException, InvalidDetailsException {
        return employeeService.createEmployee(employeeEntity) ;
    }

    @PutMapping("/employee/update")  //http://localhost:4321/bugtracker/employee/update
    public String updateEmployee(@RequestBody EmployeeEntity employeeEntity) throws RegistrationException, RecordNotFoundException{
        return employeeService.updateEmployee(employeeEntity);
    }

    @DeleteMapping("/employee/delete_by_id/{emailid}")  //http://localhost:4321/bugtracker/employee/delete_by_id/{emailid}
    public String deleteEmployee(@PathVariable String emailid) throws RegistrationException, RecordNotFoundException{
        return employeeService.deleteEmployee(emailid);
    }

    @GetMapping("/employee/view_by_id/{emailid}")  //http://localhost:4321/bugtracker/employee/view_by_id/{emailid}
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable String emailid) throws RegistrationException, RecordNotFoundException{
        return employeeService.getEmployeeById(emailid);
    }

    @GetMapping("/employee/getallemployee")  //http://localhost:4321/bugtracker/employee/getallemployee
    public List<EmployeeEntity> getAllEmployees() throws RegistrationException, RecordNotFoundException{
        return employeeService.getAllEmployees();
    }
}
