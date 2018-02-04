package com.dolap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dolap.entity.Product;
import com.dolap.service.impl.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public boolean save(@RequestBody Product product) {
        productService.insert(product);		
		
        return true;
	}
}
