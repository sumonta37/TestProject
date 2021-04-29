package com.delight.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/delight")
	public String delightDemo()
	{
		return "The application has been successfully deployed to AWS Elastic Beanstalk ";
	}

}
