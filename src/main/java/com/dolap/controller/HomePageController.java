/**

 */
package com.dolap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolap.entity.User;
import com.dolap.service.IUserService;

/**
 * @author umutates
 *2 Şub 2018
 */
@Controller
@RequestMapping(value="/")
public class HomePageController {
	
	    @Autowired
	    IUserService userService;
	
	    @RequestMapping(value= {"/","/index"})
	    public String getIndexPage() {
	        return "index";
	    }
	    
	    @RequestMapping("/login")
	    public String getLoginPage(Model model) {
	    	User user=new User();
	    	model.addAttribute("user",user);
	        return "login";
	    }
}
