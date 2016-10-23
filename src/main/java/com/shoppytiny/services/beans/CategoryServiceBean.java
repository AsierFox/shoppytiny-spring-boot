package com.shoppytiny.services.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.shoppytiny.domain.Category;
import com.shoppytiny.repositories.CategoryRepository;
import com.shoppytiny.services.CategoryService;

@Service
@Validated
public class CategoryServiceBean implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category getCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}
