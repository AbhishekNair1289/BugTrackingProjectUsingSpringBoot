package com.bugtracking.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.entity.BugInfoEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;
import com.bugtracking.service.BugInfoService;

@RestController
@RequestMapping("/bugtracker")
public class BugInfoController {
	@Autowired
	private BugInfoService bugService;

	@PostMapping("/bug_info/add")   //http://localhost:4321/bugtracker/bug_info/add
	public String createBug(@RequestBody BugInfoEntity bug) throws RegistrationException, RecordNotFoundException {
		return bugService.createBug(bug);
	}

	@PutMapping("/bug_info/update")	//http://localhost:4321/bugtracker/bug_info/update
	public String updateBug(@RequestBody BugInfoEntity bug) throws RegistrationException, RecordNotFoundException {
		return bugService.updateBug(bug);
	}

	@DeleteMapping("/bug_info/delete_bug/{bug_id}")  //http://localhost:4321/bugtracker/bug_info/delete_bug/{bug_id}
	public void deleteBug(@PathVariable int bug_id) throws RegistrationException, RecordNotFoundException{
		bugService.deleteBug(bug_id);
	}

	@GetMapping("/bug_info/view_bug/{bug_id}")  //http://localhost:4321/bugtracker/bug_info/view_bug/{bug_id}
	public Optional<BugInfoEntity> getBug(@PathVariable int bug_id) throws RegistrationException, RecordNotFoundException{
		return bugService.getBug(bug_id);
	}

	@GetMapping("/bug_info/view_all_bug")  //http://localhost:4321/bugtracker/bug_info/view_all_bug
	public List<BugInfoEntity> getAllBugs() throws RegistrationException, RecordNotFoundException{
		return bugService.getAllBugs();
	}

	@GetMapping("/bug_info/view_bug_by_status/{bug_status}")  //http://localhost:4321/bugtracker/bug_info/view_bug_by_status/{bug_status}
	public List<BugInfoEntity> getAllBugsByStatus(@PathVariable String bug_status) throws RegistrationException, RecordNotFoundException{
		return bugService.getAllBugs();
	}
}
