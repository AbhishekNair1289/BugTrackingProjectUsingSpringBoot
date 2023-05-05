package com.bugtracking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.entity.BugInfoEntity;

@Repository
public interface BugInfoDao extends JpaRepository<BugInfoEntity, Integer> {

//	List<BugInfoEntity> getAllBugsByStatus(String bug_status);
	
//	@SuppressWarnings("unchecked")
//	BugInfoEntity save(BugInfoEntity bug);
//	BugInfoEntity update(BugInfoEntity bug);
//	void deleteById(long bug_id);
//	BugInfoEntity findByBug_id(long bug_id);
//	List<BugInfoEntity> findByBug_status(String bug_status);
//	List<BugInfoEntity> findAll();
	
	}

