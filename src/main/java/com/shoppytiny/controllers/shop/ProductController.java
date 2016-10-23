package com.shoppytiny.controllers.shop;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shoppytiny.domain.Product;
import com.shoppytiny.services.ProductService;

/**
 * Product controller.
 */
@RestController
@RequestMapping(value="/shop/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(
			value="/products",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView shopProducts() {
		ModelAndView mv = new ModelAndView("products");
		List<Product> allProducts = productService.findAll();
		
		mv.addObject("allProducts", allProducts);
		
		return mv;
	}
	
	@RequestMapping(
			value="/products/{productName}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showProductByName(@PathVariable String productName) {
		ModelAndView mv = new ModelAndView("product");
		List<Product> produtSet = productService.findByName(productName);
		Product product = null;
		
		if (!produtSet.isEmpty()) {
			product = produtSet.get(0);
		}

		mv.addObject("isProduct", !produtSet.isEmpty());
		mv.addObject("product", product);
		
		return mv;
	}
	
	@RequestMapping(
			value="/products/search",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView shopSearchProducts(@RequestParam(value="name", required=true)  String productName) {
		ModelAndView mv = new ModelAndView("search_products");		
		List<Product> allProducts = productService.findByName(productName);

		mv.addObject("searchedName", productName);
		mv.addObject("allProducts", allProducts);
		mv.addObject("areProducts", allProducts.isEmpty());
		
		return mv;
	}
	
	@RequestMapping(
			value="/products/create",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showCreateProduct(Model model) {
		ModelAndView mv = new ModelAndView("create_product");
		
		model.addAttribute("product", new Product());
		
		return mv;
	}

	@RequestMapping(
			value="/products/create",
			method=RequestMethod.POST)
	public ModelAndView createProduct(@Valid final Product product, BindingResult bindingResult) {
		ModelMap model = new ModelMap();
		ModelAndView mv = new ModelAndView("create_product", model);
		Product savedProduct = productService.save(product);
		
		if (savedProduct == null) {
			mv.addObject("isSaved", "Error saving the product!");
		} else {
			mv.addObject("isSaved", "The product has been saved!");
		}
		return mv;
	}
}
