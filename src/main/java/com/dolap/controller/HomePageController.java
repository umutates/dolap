/**

 */
package com.dolap.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolap.entity.Product;
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
	
	 private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	    @Autowired
	    IUserService userService;
	    
	    @Autowired
	    IProductService productService;
	    
	  
	    @RequestMapping(value= {"/","/index"})
	    public String getIndexPage(Model model) {
	    	List<Product> products=productService.findAll();
	    	LOG.error("Products:", products);;
	    	model.addAttribute("products",products);
	        return "index";
	    }
	    
	    @RequestMapping("/login")
	    public String getLoginPage(Model model) {
	    	User user=new User();
	    	model.addAttribute("user",user);
	        return "login";
	    }
	    @RequestMapping(value= {"/product"})
	    public String getAddProduct(Model model) {
		    model.addAttribute("product", new Product());
	        return "product-add";
	    }
		
	    @Cacheable(value = "products")
	    public void addAttribute(Model model) {
	    	LOG.info("products were taken to cache");
	    	model.addAttribute("products",productService.findAll());
	    }

}
