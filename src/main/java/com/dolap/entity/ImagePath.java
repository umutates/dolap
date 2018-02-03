package com.dolap.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * @author umutates
 * @since 2 Şub 2018
 */
@Entity
@Table(name="IMAGEPATH")
public class ImagePath {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private Long luc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product")
	private Product product;
	
	private String imagePath;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
