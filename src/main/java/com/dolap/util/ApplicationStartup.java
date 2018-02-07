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
		
		Set<Image> images3=new HashSet<Image>();
		Image image5=new Image();
		image5.setImagePath("images/home/product6.jpg");
		image5.setFileName("product6.jpg");
		Image image6=new Image();
		image6.setImagePath("images/home/product1.jpg");
		image6.setFileName("product1.jpg");
		images3.add(image5);
		images3.add(image6);
		Product product3=new Product("Product3","Product3",new BigDecimal(100),images3,"NIKE",ProductType.TSHIRT.name());
		productService.insert(product3);
		
		Set<Image> images4=new HashSet<Image>();
		Image image7=new Image();
		image7.setImagePath("images/home/product1.jpg");
		image7.setFileName("product1.jpg");
		Image image8=new Image();
		image8.setImagePath("images/home/product2.jpg");
		image8.setFileName("product2.jpg");
		images4.add(image7);
		images4.add(image8);
		Product product4=new Product("Product4","Product4",new BigDecimal(100),images4,"NIKE",ProductType.SUNGLASS.name());
		productService.insert(product4);
		
		Set<Image> images6=new HashSet<Image>();
		Image image11=new Image();
		image11.setImagePath("images/home/product4.jpg");
		image11.setFileName("product4.jpg");
		Image image12=new Image();
		image12.setImagePath("images/home/product5.jpg");
		image12.setFileName("product5.jpg");
		images6.add(image11);
		images6.add(image12);
		Product product6=new Product("Product6","Product6",new BigDecimal(100),images6,"NIKE",ProductType.KIDS.name());
		productService.insert(product6);
		
		Set<Image> images10=new HashSet<Image>();
		Image image20=new Image();
		image20.setImagePath("images/home/product2.jpg");
		image20.setFileName("product5.jpg");
		Image image21=new Image();
		image21.setImagePath("images/home/product1.jpg");
		image21.setFileName("product5.jpg");
		images10.add(image20);
		images10.add(image21);
		Product product5=new Product("Product5","Product5",new BigDecimal(100),images10,"NIKE",ProductType.POLOSHIRT.name());
		productService.insert(product5);
		

	}
}