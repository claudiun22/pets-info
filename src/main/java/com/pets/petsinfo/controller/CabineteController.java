package com.pets.petsinfo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pets.petsinfo.model.Cabinete;
import com.pets.petsinfo.repository.CabineteRepository;
import com.pets.petsinfo.repository.PensiuniRepository;

@Controller
public class CabineteController {
	
	
	@Autowired
	CabineteRepository crepository;
	
	@GetMapping(value = "/petsinfo/cabinete")
	public String home( Model model ) {
		List<Cabinete> list = new ArrayList<Cabinete>();
		List<String> listaOrase = new ArrayList<String>();
		list = crepository.findAll();
		listaOrase = crepository.findLocatie();
		model.addAttribute("cabinete", list);
		model.addAttribute("listaOrase", listaOrase);
		return "cabinete";
	}
	
	@RequestMapping("/petsinfo/cabinet/{id}")
	public String detaliiCabinet(@PathVariable("id") Long id, Model model ) {
		Cabinete cabinet = crepository.getOne(id);
		model.addAttribute("cabinet", cabinet);
		return "cabinet";
	}
	
	@GetMapping(value = "/petsinfo/admincabinete/{id}")
	public String adminCabinete(@PathVariable("id") Long id, Model model) {
		Cabinete cabinet = crepository.getOne(id);
		model.addAttribute("cabinet", cabinet);
		Boolean editable = true;
		model.addAttribute("edit", editable);
		return "admincabinete";
	}
	
	@GetMapping(value = "/petsinfo/admincabinete")
	public String adminCabineteEdit( Model model ) {
		List<Cabinete> list = new ArrayList<Cabinete>();
		list = crepository.findAll();
		model.addAttribute("cabinete", list);
		Boolean editable = false;
		model.addAttribute("edit", editable);
		return "admincabinete";
	}
	
	@PostMapping(value="/petsinfo/admincabinete/{id}")
	public String updateCabinete(@PathVariable("id") Long id, Cabinete cabinet, Model model) {
		crepository.saveAndFlush(cabinet);
		model.addAttribute("cabinete", crepository.findAll());
		return "admincabinete";
	}
	
	@GetMapping("/petsinfo/addCabinet")
	public String formCabinet(Cabinete cabinet, Model model) {
		model.addAttribute("cabinet", cabinet);
		return "addCabinet";
	}
	
	@PostMapping("/petsinfo/addCabinet")
    public String addCabinet(Cabinete cabinet, Model model) { 
        crepository.save(cabinet);
        model.addAttribute("users", crepository.findAll());
        return "admincabinete";
    }
	
	@GetMapping("/petsinfo/deleteCabinet/{id}")
	public String deleteCabinet(@PathVariable("id") Long id, Model model) {
		crepository.deleteById(id);
		model.addAttribute("cabinete", crepository.findAll());
		return "admincabinete";
	}
	
}
