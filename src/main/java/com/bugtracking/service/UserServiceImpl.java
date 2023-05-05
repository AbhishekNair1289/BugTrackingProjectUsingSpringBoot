package com.bugtracking.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	public String showmenu() {

		return "\t\t\t*****Bug Tracking Application*****\n\n\n\t\t\t\tChose one from the below option\n\n\t\t\t\t1. Login\n\t\t\t\t2. Create Account";
	}

}
