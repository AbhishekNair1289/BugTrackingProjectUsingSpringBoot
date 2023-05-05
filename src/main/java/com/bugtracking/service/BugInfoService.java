package com.bugtracking.service;

import java.util.*;

import org.springframework.data.domain.Sort;

import com.bugtracking.entity.BugInfoEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;



public interface BugInfoService {
	public String createBug(BugInfoEntity bug) throws RegistrationException, RecordNotFoundException;
	public String updateBug(BugInfoEntity bug) throws RegistrationException, RecordNotFoundException;
	public Optional<BugInfoEntity> getBug(int bug_id) throws RegistrationException, RecordNotFoundException;
	public List<BugInfoEntity> getAllBugs() throws RegistrationException, RecordNotFoundException;
//	public List<BugInfoEntity> getAllBugsByStatus(String bug_status);
	public String deleteBug(int bug_id) throws RegistrationException, RecordNotFoundException;
	public List<BugInfoEntity> getAllBugsByStatus(Sort bug_status) throws RegistrationException, RecordNotFoundException;
	
	
}
