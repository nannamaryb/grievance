package com.pg.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pg.entity.LogData;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("LogData", new LogData());
		return "login";
	}
	
	
	@PostMapping("/data")
	public String processLogin(@Valid @ModelAttribute("LogData") LogData logData, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
	 	 	return "login";  
		}
		System.out.println(logData);
		return "success";
	} 
}
 
  