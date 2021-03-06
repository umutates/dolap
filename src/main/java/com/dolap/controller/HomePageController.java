/**

 */
package com.dolap.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dolap.entity.Product;
import com.dolap.entity.User;
import com.dolap.service.IProductService;
import com.dolap.service.IUserService;
import com.dolap.util.ProductType;

/**
 * @author umutates 2 Şub 2018
 */
@Controller
@RequestMapping(value = "/")
public class HomePageController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	IUserService userService;

	@Autowired
	IProductService productService;

	@RequestMapping(value = { "/", "/index" })
	public String getIndexPage(Model model) {
		LOG.info("return index page");
		return "index";
	}
	
	@RequestMapping(value = { "/product" })
	public String getAddProduct(Model model) {
		model.addAttribute("product", new Product());
		LOG.info("return product page");
		return "product-add";
	}

	@RequestMapping("/login")
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		LOG.info("return login page");
		return "login";
	}

	@ModelAttribute
	public void addProductsAttribute(Model model) {
		model.addAttribute("products", productService.findAll());
		LOG.info("All Product added to model");
	}
	@ModelAttribute
	public void addProductTypeAttribute(Model model) {
		String[] productTypes=Arrays.stream(ProductType.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
		model.addAttribute("productTypes",productTypes);
		LOG.info("All Product Types added to model");
	}

}
