package com.bugtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.service.UserServiceImpl;

@RestController
@RequestMapping("/bugtracker")
public class UserController {

	@Autowired
	private UserServiceImpl homepage;

	// GET USER DETAILS BY EMAIL
	@GetMapping("/home")
	public String showmenu()

	{

		return homepage.showmenu();
	}

}
