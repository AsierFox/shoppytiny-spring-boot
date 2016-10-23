package com.shoppytiny.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.shoppytiny.domain.Category;
import com.shoppytiny.domain.Product;

@Service
@Validated
public interface ProductService {
    List<Product> findAll();
    List<Product> findByName(String productName);
	List<Product> findByCategoryName(Set<Category> category);
	List<Product> findByCategoryName(Category category);
	Product save(Product product);
}
