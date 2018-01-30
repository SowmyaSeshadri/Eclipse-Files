package com.zilker.signupform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String signUpForm() {
		return "index";
	}
	
	@RequestMapping("/display")
	public String displayDetails() {
		System.out.println("In");
		return "forward:/SignUp";
	}
	
	@RequestMapping("/success")
	public String onSuccess() {
		System.out.println("Success");
		return "success";
	}
	
	
}
