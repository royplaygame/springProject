package com.hy.ly.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hy.ly.annotation.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	public void execute(){
		System.out.println("UserController's execute()......");
		userService.add();
	}
}
