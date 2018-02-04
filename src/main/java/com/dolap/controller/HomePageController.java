/**

 */
package com.dolap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolap.entity.User;

/**
 * @author umutates
 *2 Şub 2018
 */
@Controller
@RequestMapping(value="/")
public class HomePageController {
	
	    @RequestMapping(value="/")
	    public String getIndexPage() {
	        return "index";
	    }
	    
	    @RequestMapping("/login")
	    public String getLoginPage(Model model) {
	    	User user=new User();
	    	model.addAttribute("user",user);
	        return "login";
	    }
	    
	    @RequestMapping("/saveUser")
	    public String saveUser(Model model) {
	    	User user=new User();
	        return "login";
	    }

}
