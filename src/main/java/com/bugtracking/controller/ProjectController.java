package com.bugtracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.entity.ProjectEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;
import com.bugtracking.service.ProjectService;

@RestController
@RequestMapping("/bugtracker")
public class ProjectController {
	@Autowired
	ProjectService service;

	@PostMapping("/project/addProject")   //http://localhost:4321/bugtracker/project/addProject
	public String addProject(@RequestBody @Valid ProjectEntity projectEntity) throws RegistrationException, RecordNotFoundException{
		return service.addProject(projectEntity);
	}

	@DeleteMapping("/project/deleteProject/{pid}")  //http://localhost:4321/bugtracker/project/deleteProject/{pid}
	public String deleteProject(@PathVariable("pid") long projId) throws RegistrationException, RecordNotFoundException{
		return service.deleteProject(projId);
	}

	@PutMapping("/project/updateProject")  //http://localhost:4321/bugtracker/project/updateProject
	public String updateProject(@RequestBody @Valid ProjectEntity projectEntity) throws RegistrationException, RecordNotFoundException{
		return service.updateProject(projectEntity);
	}

	@GetMapping("/project/getProject/{pid}")  //http://localhost:4321/bugtracker/project/getProject/{pid}
	public ProjectEntity getProject(@PathVariable("pid") long projId) throws RegistrationException, RecordNotFoundException{
		return service.getProject(projId);
	}

	@GetMapping("/project/getallProjects")  //http://localhost:4321/bugtracker/project/getallProjects
	public List<ProjectEntity> getAllProjects() throws RegistrationException, RecordNotFoundException{	
		return service.getAllProjects();
	} 
	
	
}
