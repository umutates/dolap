package com.dolap.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;



/**
 * @author umutates
 * @since 2 Şub 2018
 */



@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private Long luc;

	@Column(length = 50)
	private String name;

	@Column(name = "SHORT_DESC", length = 200)
	private String shortDescription;

	@Column(name = "LONG_DESC", length = 500)
	private String longDescription;

	private BigDecimal price;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "product")
	private Set<ImagePath> images;

	@Column(name = "PRODUCT_TYPE", insertable = false, updatable = false)
	private String productType;


	public Product() {
	}

	public Product(String shortDescription, String longDescription, BigDecimal price,
			Set<ImagePath> largeImagePath,String name) {
		super();
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.price = price;
		this.images = largeImagePath;
		this.name=name;
	}

	public Long getLuc() {
		return luc;
	}

	public void setLuc(Long luc) {
		this.luc = luc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", shortDescription=" + shortDescription + ", longDescription="
				+ longDescription + ", price=" + price + ", smallImagePath=" + images + ", productType="
				+ productType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}

