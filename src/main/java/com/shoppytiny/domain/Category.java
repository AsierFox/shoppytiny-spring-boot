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
 * Category for a product.
 */
@Entity
@Table(name="Categories")
public class Category implements Serializable {

	private static final long serialVersionUID = -6952632864181129279L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false, updatable=false)
	private int id;
	
	@Size(max=80)
	@Column(name="name", nullable=false)
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CategoryProduct",
		joinColumns = @JoinColumn(name="product_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName="id"))
	private Set<Product> products;
	
	Category() {}
	
	public Category(final int id, final String name) {
		this.id = id;
		this.name = name;
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
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
