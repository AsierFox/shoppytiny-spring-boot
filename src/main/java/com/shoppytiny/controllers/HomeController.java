package com.shoppytiny.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/")
public class HomeController {

	@RequestMapping(
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(
			value="/home",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}
