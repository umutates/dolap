package com.dolap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolap.entity.User;
import com.dolap.service.IUserService;
import com.dolap.util.Role;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("/save")
	public String save(@ModelAttribute User user) {
		user.setRole(Role.USER.name());
		userService.insert(user);
		return "redirect:/";
	}

}
