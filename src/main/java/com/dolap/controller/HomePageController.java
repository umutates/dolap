/**

 */
package com.dolap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolap.entity.User;
import com.dolap.service.IProductService;
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
	    
	    @Autowired
	    IProductService productService;
	
	    @RequestMapping(value= {"/","/index"})
	    public String getIndexPage(Model model) {
	        return "index";
	    }
	    
	    @RequestMapping("/login")
	    public String getLoginPage(Model model) {
	    	User user=new User();
	    	model.addAttribute("user",user);
	        return "login";
	    }
	    
	    @ModelAttribute
	    public void addAttribute(Model model) {
	    	model.addAttribute("products",productService.findAll());
	    }
}
