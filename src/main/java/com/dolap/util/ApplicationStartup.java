package com.dolap.util;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.dolap.entity.ImagePath;
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
		Set<ImagePath> images=new HashSet<ImagePath>();
		ImagePath imagePath=new ImagePath();
		imagePath.setImagePath("/product/image");
		images.add(imagePath);
		Product product=new Product("Kazak","Kazak",new BigDecimal(100),images,"NIKE");
		productService.insert(product);
		

	}
}