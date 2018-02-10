package com.dolap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import com.dolap.entity.Image;
import com.dolap.entity.Product;
import com.dolap.repository.IProductDao;
import com.dolap.service.IProductService;
import com.dolap.util.ProductType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	private static String PARENT_FOLDER = "images/home/";

	@Autowired
	IProductService productService;

	@Autowired
	IProductDao productDao;

	Product product1;

	Image image1;
	Image image2;

	@Before
	public void beforeSetUp() {
		product1 = new Product();
		product1.setLongDescription("TestProduct");
		product1.setPrice(new BigDecimal("10"));
		product1.setProductType(ProductType.KIDS.name());
		product1.setShortDescription("TestProduct");

		image1 = new Image();
		image1.setFileName("Test.jpg");
		image1.setImagePath(PARENT_FOLDER + "Test1.jpg");

		image2 = new Image();
		image2.setFileName("Test2.jpg");
		image2.setImagePath(PARENT_FOLDER + "Test2.jpg");

		Set<Image> images = new HashSet<>();
		images.add(image1);
		images.add(image2);

		product1.setImages(images);

	}

	@After
	public void afterOperation() {
		if (product1.getId()!=null&&productService.findById(product1.getId())!=null) {
			productService.delete(product1.getId());
		}

	}

	@Test
	public void shoulreturnIdWhenInsertProduct() {
		productService.insert(product1);
		assertNotNull(product1.getId());
	}

	@Test
	public void shoulreturnAllProductWhenCallFindAll() {
		assertNotNull(productService.findAll());
	}

	@Test(expected=NullPointerException.class)
	public void shoulthrowNullPointerWhenCallDeleteByNull() {
		productService.delete(null);
	}
	
	@Test
	public void shoulFindNotFoundProductWhenCallDelete() {
		productService.insert(product1);
		Integer productId = product1.getId();
		productService.delete(productId);
		assertNull(productService.findById(productId));
	}
	
	@Test(expected=InvalidDataAccessApiUsageException.class)
	public void shoulThrowExceptionProductWhenInsertDetachedEntityPassed() {
	     productService.insert(product1);
	     productService.insert(product1);
	}
	

}
