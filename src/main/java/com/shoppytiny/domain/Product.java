package com.shoppytiny.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Product of the shop.
 */
@Entity
@Table(name="Products")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 6317004059874042488L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false, updatable=false)
	private int id;
	
	@Size(max=80)
	@Column(name="name", nullable=false)
	private String name;
	
	@Size(max=80)
	@Column(name="image", nullable=false)
	private String image;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="price", nullable=false)
	private float price;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CategoryProduct",
		joinColumns = @JoinColumn(name="product_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName="id"))
	private Set<Category> categories;
	
	public Product() {}
	
	public Product(final int id, final String name, Set<Category> category) {
		this.id = id;
		this.name = name;
		this.categories = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
