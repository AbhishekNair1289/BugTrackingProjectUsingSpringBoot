package com.bugtracking.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bugtracking.entity.ProjectEntity;

public interface ProjectDao extends JpaRepository<ProjectEntity, Long>{

	
}
	