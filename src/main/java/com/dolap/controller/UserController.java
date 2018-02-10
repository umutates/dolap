package com.dolap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dolap.entity.User;
import com.dolap.service.IUserService;
import com.dolap.util.Role;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("/save")
	public String save(@ModelAttribute User user,RedirectAttributes redirectAttributes) {
		User exitsUser=userService.findByEmail(user.getEmail());
		if (exitsUser==null) {
			user.setRole(Role.USER.name());
			userService.insert(user);
			redirectAttributes.addFlashAttribute("message","Registration Successful!Please Login...");
		}
		else {
			redirectAttributes.addFlashAttribute("message","This email address already registered");
		}
	
		return "redirect:/login";
	}

}
