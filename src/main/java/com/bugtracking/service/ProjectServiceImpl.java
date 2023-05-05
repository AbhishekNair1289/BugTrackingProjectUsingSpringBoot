package com.bugtracking.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.dao.ProjectDao;
import com.bugtracking.entity.ProjectEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectDao dao;


	@Override
	public String addProject(ProjectEntity projectEntity) throws RegistrationException, RecordNotFoundException {
		dao.save(projectEntity);
		return "Project Inserted Successfully";
	}

	@Override
	public String deleteProject(long projId)throws RegistrationException, RecordNotFoundException {
		dao.deleteById(projId);
		return "Project Deleted Successfully";
		
	}

	@Override
	public String updateProject(ProjectEntity projectEntity) throws RegistrationException, RecordNotFoundException{
		dao.save(projectEntity);
		return "Project Updated Successfully";
	}

	@Override
	public ProjectEntity getProject(long projId) throws RegistrationException, RecordNotFoundException{
		Optional<ProjectEntity>projectEntity=dao.findById(projId);
		return projectEntity.get();
	}

	@Override
	public List<ProjectEntity> getAllProjects() throws RegistrationException, RecordNotFoundException{
		return dao.findAll();
	}
	
	
	
	
}
