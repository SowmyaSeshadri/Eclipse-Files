package com.zilker.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
	@RequestMapping("/")
	public String testingSpring() {
		return "index";
	}
	
}
