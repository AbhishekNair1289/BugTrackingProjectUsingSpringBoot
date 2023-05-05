package com.bugtracking.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugtracking.dao.AdminDao;
import com.bugtracking.entity.AdminEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
    AdminDao adminDao;

    @Override
    public String createAdmin(AdminEntity admin) throws RegistrationException, RecordNotFoundException {
        adminDao.save(admin);
        return "Admin Created Successfully";
    }

    @Override
    public AdminEntity getByAdminId(String emailid) throws  RecordNotFoundException  {
        return adminDao.findByMail(emailid);
    }

    

}
