package com.bugtracking.service;

import java.util.List;

import com.bugtracking.entity.ProjectEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;

public interface ProjectService {

	public String addProject(ProjectEntity projectEntity) throws RegistrationException, RecordNotFoundException;
	
	public String deleteProject(long projId) throws RegistrationException, RecordNotFoundException;
	
	public String updateProject(ProjectEntity projectEntity) throws RegistrationException, RecordNotFoundException;
	
	public ProjectEntity getProject(long projId) throws RegistrationException, RecordNotFoundException;
	
	public List<ProjectEntity> getAllProjects() throws RegistrationException, RecordNotFoundException;
}
