package com.pets.petsinfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pets.petsinfo.model.Cabinete;
import com.pets.petsinfo.model.Pensiuni;
import com.pets.petsinfo.repository.CabineteRepository;
import com.pets.petsinfo.repository.PensiuniRepository;

@Controller
public class HomeController {
	
	@GetMapping(value = "/petsinfo")
	public ModelAndView homeindex( Model model ) {
		return new ModelAndView("homepage") ;
	}
	
	@GetMapping(value = "/admin")
	public String admin( Model model ) {
		return "admin";
	}
	
	@GetMapping(value = "/contact")
	public String contact( Model model ) {
		return "contact";
	}
	
	@RequestMapping("/main")
	public String main( Map<String, Object> model ) {
		model.put("message", "Hllo World Main Page");
		return "main";
	}
	


}
