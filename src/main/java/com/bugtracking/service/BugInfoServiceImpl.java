package com.bugtracking.service;

import java.util.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bugtracking.dao.BugInfoDao;
import com.bugtracking.entity.BugInfoEntity;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;



@Service
@Transactional
public class BugInfoServiceImpl implements BugInfoService {
	@Autowired
	private BugInfoDao dao;
	
	@Override
	public String createBug(BugInfoEntity bug) throws RegistrationException, RecordNotFoundException {
		dao.save(bug);
		return "Bug Created Successfully!";
	}

	@Override
	public String updateBug(BugInfoEntity bug) throws RegistrationException, RecordNotFoundException{
		dao.save(bug);
		return "Bug updated Successfully!";
	}

	@Override
	public String deleteBug(int bug_id) throws RegistrationException, RecordNotFoundException {
		dao.deleteById(bug_id);
		return "Bug Deleted Successfully!";
	}

	@Override
	public Optional<BugInfoEntity> getBug(int bug_id) throws RegistrationException, RecordNotFoundException{
		return dao.findById(bug_id);
	}

	@Override
	public List<BugInfoEntity> getAllBugs() throws RegistrationException, RecordNotFoundException{
		return dao.findAll();
	}

	@Override
	public List<BugInfoEntity> getAllBugsByStatus(Sort bug_status) throws RegistrationException, RecordNotFoundException{
		return dao.findAll(bug_status);
	}
}
