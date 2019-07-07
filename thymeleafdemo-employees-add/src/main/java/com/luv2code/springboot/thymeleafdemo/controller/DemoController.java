package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	//create a mapping for "/hello"
	
	@GetMapping(value="/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new Date());
		
		return "helloworld";
		//we have ThymeLeaf dependency in Maven POM
		//spring boot will auto-configure to use ThymeLeaf
		//in src/main/resources/templates/hellowworld.html
	}
}
