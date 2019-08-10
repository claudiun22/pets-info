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

import com.pets.petsinfo.model.Pensiuni;
import com.pets.petsinfo.repository.CabineteRepository;
import com.pets.petsinfo.repository.PensiuniRepository;

@Controller
public class PensiuniController {
	
	
	@Autowired
	PensiuniRepository prepository;
	
	@GetMapping(value = "/petsinfo/pensiuni")
	public String index( Model model ) {
		List<Pensiuni> list = new ArrayList<Pensiuni>();
		List<String> listaOrase = new ArrayList<String>();
		list = prepository.findAll();
		model.addAttribute("pensiuni", list);
		listaOrase = prepository.findOrase();
		model.addAttribute("listaOrase", listaOrase);
		return "pensiuni";
	}
	
	@PostMapping(value = "/petsinfo/pensiuni")
	public String FindByOras(Pensiuni oras, Model model ) {
		List<Pensiuni> listOrasDistinct = new ArrayList<Pensiuni>();
		listOrasDistinct = prepository.findDistinctByOras(oras.getOras());
		model.addAttribute("orase", listOrasDistinct);
		List<Pensiuni> list = new ArrayList<Pensiuni>();
		List<String> listaOrase = new ArrayList<String>();
		listaOrase = prepository.findOrase();
		model.addAttribute("listaOrase", listaOrase);
		
		return "pensiuni";
	}
	
	@RequestMapping("/petsinfo/pensiune/{id}")
	public String detaliiPensiune(@PathVariable("id") Long id, Model model ) {
		Pensiuni pensiune = prepository.getOne(id);
		model.addAttribute("pensiune", pensiune);
		return "pensiune";
	}
	
	@GetMapping("/petsinfo/addPensiune")
	public String formCabinet(Pensiuni pensiune, Model model) {
		model.addAttribute("pensiune", pensiune);
		return "addPensiune";
	}
	
		
	@GetMapping(value = "/petsinfo/adminpensiuni")
	public String adminPensiuni( Model model ) {
		List<Pensiuni> list = new ArrayList<Pensiuni>();
		list = prepository.findAll();
		model.addAttribute("pensiuni", list);
		Boolean editable = false;
		model.addAttribute("edit", editable);
		return "adminpensiuni";
	}
	
	@GetMapping(value = "/petsinfo/adminpensiuni/{id}")
	public String adminPensiuni( @PathVariable("id") Long id, Model model) {
		Pensiuni pensiune = prepository.getOne(id);
		model.addAttribute("pensiune", pensiune);
		Boolean editable = true;
		model.addAttribute("edit", editable);
		return "adminpensiuni";
	}
	
	@GetMapping("/petsinfo/deletePensiune/{id}")
	public String deletePensiune(@PathVariable("id") Long id, Model model) {
		prepository.deleteById(id);
		model.addAttribute("cabinete", prepository.findAll());
		return "adminpensiuni";
	}
	
	@PostMapping(value="/petsinfo/adminpensiuni/{id}")
	public String updatePensiuni(@PathVariable("id") Long id, Pensiuni pensiune, Model model) {
		prepository.saveAndFlush(pensiune);
		model.addAttribute("pensiuni", prepository.findAll());
		return "adminpensiuni";
	}
	
}
