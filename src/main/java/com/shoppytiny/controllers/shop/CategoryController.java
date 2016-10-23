package com.shoppytiny.controllers.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shoppytiny.domain.Category;
import com.shoppytiny.domain.Product;
import com.shoppytiny.services.CategoryService;
import com.shoppytiny.services.ProductService;

@RestController
@RequestMapping(value="/shop/")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@RequestMapping(
			value="/categories",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView allCategories() {
		ModelAndView mv = new ModelAndView("categories");
		List<Category> allCategories = categoryService.findAll();
		
		mv.addObject("allCategories", allCategories);
		
		return mv;
	}
	
	@RequestMapping(
			value="/categories/{category_name}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView shopCategoryProducts(@PathVariable("category_name") String categoryName) {
		ModelAndView mv = new ModelAndView("category_products");
		Category category = categoryService.getCategoryByName(categoryName);
		List<Product> allProducts = new ArrayList<>();
		
		if (category != null) {
			allProducts = productService.findByCategoryName(category);
		}

		mv.addObject("allProducts", allProducts);
		mv.addObject("areProducts", allProducts.isEmpty());
		mv.addObject("categoryName", categoryName);
		
		return mv;
	}
}
