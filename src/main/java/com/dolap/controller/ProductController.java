package com.dolap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolap.entity.Product;
import com.dolap.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	IProductService productService;

	@PostMapping("/save")
	public String save(@ModelAttribute Product product) {
		return "redirect:/";
	}
}
