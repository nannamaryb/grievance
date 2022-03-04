package com.pg.controller;
 
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pg.entity.RegData;
import com.pg.gender.Gender;
import com.pg.service.RegDataService;
 
@Controller
public class PController {
	
	@Autowired
	RegDataService logDataService;
 
	@RequestMapping("/")
	public String index(Model model) throws IOException
	{
		model.addAttribute("RegData", new RegData());
		model.addAttribute("state",logDataService.getAllState());
		model.addAttribute("district",logDataService.getAllDistrict());
		model.addAttribute("gender_value", Gender.values());

		return "index"; 
	}  
	
	@PostMapping("/addPg")
	public String processForm(@Valid @ModelAttribute("RegData") RegData regData, BindingResult result, Model model,@RequestParam("files") MultipartFile file) throws IOException
	{
		
		if(result.hasErrors())
		{
	 		System.out.println(result);
			model.addAttribute("gender_value",Gender.values());
			model.addAttribute("state",logDataService.getAllState());
			model.addAttribute("district",logDataService.getAllDistrict());

		}
		else 
		{
				if(file.isEmpty()==true)
				{
					logDataService.saveContent(null, regData); 
				}
				else {
					logDataService.saveContent(file, regData);
				}
				
		}
		return "redirect:/"; 
	} 
	
}  
    
   

  
         