package com.shoppytiny.services.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.shoppytiny.domain.Category;
import com.shoppytiny.domain.Product;
import com.shoppytiny.repositories.ProductRepository;
import com.shoppytiny.services.ProductService;

@Service
@Validated
public class ProductServiceBean implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByCategoryName(Set<Category> categories) {
		return productRepository.findByCategories(categories);
	}
	
	@Override
	public List<Product> findByName(String productName) {
		return productRepository.findByName("%" + productName + "%");
	}
	
	@Override
	public List<Product> findByCategoryName(Category category) {
		Set<Category> categories = new HashSet<>();
		categories.add(category);
		return productRepository.findByCategories(categories);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
}
