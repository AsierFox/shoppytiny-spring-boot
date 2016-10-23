package com.shoppytiny.controllers.shop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/shop")
public class ShopController {

	@RequestMapping(
			value="",
			method=RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("home_shop");
	}
}
