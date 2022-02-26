package com.pg;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.pg.entity.RegData;
import com.pg.gender.Gender;
import com.pg.service.LogDataService;
 
@Controller
public class PController {
	
	@Autowired
	LogDataService logDataService;
 
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("RegData", new RegData());
		model.addAttribute("gender_value", Gender.values());
		return "index";
	} 
	
	@PostMapping("/addPg")
	public String processForm(@Valid @ModelAttribute("RegData") RegData regData, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
	 		System.out.println(result);
			model.addAttribute("gender_value",Gender.values());
		}else {
			logDataService.addPg(regData);
		}
 		return "index"; 
	}
	
} 
  
 

 
         