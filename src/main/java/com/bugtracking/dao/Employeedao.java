package com.bugtracking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.bugtracking.entity.EmployeeEntity;
//

@Repository
public interface Employeedao extends JpaRepository<EmployeeEntity, String>{

    
//    @SuppressWarnings("unchecked")
//	EmployeeEntity save(EmployeeEntity employeeEntity);
//    
//    EmployeeEntity update(EmployeeEntity employeeEntity);
//    
//    void deleteById(Long employeeId);
//    
//    Optional<EmployeeEntity> findByEmail(String email);
//    
//    List<EmployeeEntity> findAll();
}