/**

 */
package com.dolap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author umutates
 *2 Şub 2018
 */
@Controller
public class HomePageController {
	
	    @RequestMapping("/")
	    public String getHomePage() {
	        return "home";
	    }
	    
	    @RequestMapping("/index")
	    public String getIndexPage() {
	        return "index";
	    }

}
