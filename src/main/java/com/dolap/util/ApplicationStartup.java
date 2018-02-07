package com.dolap.util;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.dolap.entity.Image;
import com.dolap.entity.Product;
import com.dolap.entity.User;
import com.dolap.service.IProductService;
import com.dolap.service.IUserService;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {
       @Autowired
       IUserService userService;
       
       @Autowired
       IProductService productService;
  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
	  addAdmin();
	  addProduct();

	}
	
	public void addAdmin() {
		if (userService.findByEmail("admin@dolap.com") == null) {
			User user = new User();
			user.setEmail("admin@dolap.com");
			user.setName("dolap");
			user.setPassword("dolap");
			user.setRole(Role.ADMIN.name());
			userService.insert(user);
		}

	}
	
	public void addProduct() {
		Set<Image> images1=new HashSet<Image>();
		Image image1=new Image();
		image1.setImagePath("images/home/product2.jpg");
		image1.setFileName("product2.jpg");
		Image image2=new Image();
		image2.setImagePath("images/home/product3.jpg");
		image2.setFileName("product3.jpg");
		images1.add(image1);
		images1.add(image2);
		Product product1=new Product("Product1","Product1",new BigDecimal(100),images1,"NIKE",ProductType.TSHIRT.name());
		productService.insert(product1);
		
		Set<Image> images2=new HashSet<Image>();
		Image image3=new Image();
		image3.setImagePath("images/home/product4.jpg");
		image3.setFileName("product4.jpg");
		Image image4=new Image();
		image4.setImagePath("images/home/product5.jpg");
		image4.setFileName("product5.jpg");
		images2.add(image3);
		images2.add(image4);
		Product product2=new Product("Product2","Product2",new BigDecimal(100),images2,"NIKE",ProductType.BLAZERS.name());
		productService.insert(product2);
		

	}
}