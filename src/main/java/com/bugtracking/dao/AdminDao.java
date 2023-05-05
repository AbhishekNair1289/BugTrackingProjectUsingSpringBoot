package com.bugtracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.entity.AdminEntity;

@Repository
public interface AdminDao extends JpaRepository<AdminEntity, String> {

//	AdminEntity findByEmai(String emailid);
	
//	@SuppressWarnings("unchecked")
//	AdminEntity save(AdminEntity admin);
//
	AdminEntity findByMail(String mail);

}
