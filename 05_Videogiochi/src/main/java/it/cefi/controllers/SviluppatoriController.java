package it.cefi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.cefi.models.Sviluppatore;
import it.cefi.services.SviluppatoriService;

@Controller
public class SviluppatoriController {
	
	@Autowired
	private SviluppatoriService sviluppatoriService;
	
	@GetMapping("/sviluppatori/list")
	public String list(Model model) {
		model.addAttribute("sviluppatori", sviluppatoriService.getSviluppatori());
		return "sviluppatori/list";
	}
	
	@GetMapping("/sviluppatori/edit")
	public String edit(Model model) {
		model.addAttribute("sviluppatore", new Sviluppatore());
		return "sviluppatori/edit";
	}
	
	@GetMapping("/sviluppatori/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("sviluppatore", sviluppatoriService.getSviluppatore(id));
		return "sviluppatori/edit";
	}
	
	@PostMapping("/sviluppatori/edit")
	public ModelAndView edit(@ModelAttribute Sviluppatore sviluppatore) {
		sviluppatoriService.saveSviluppatore(sviluppatore);
		return new ModelAndView ("redirect:/sviluppatori/list");
	}
	
	@GetMapping("/sviluppatori/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		model.addAttribute("sviluppatore", sviluppatoriService.getSviluppatore(id));
		return "sviluppatori/delete";
	}
	
	@PostMapping("/sviluppatori/delete")
	public ModelAndView delete(@ModelAttribute Sviluppatore sviluppatore) {
		sviluppatoriService.deleteSviluppatore(sviluppatore.getId());
		return new ModelAndView("redirect:/sviluppatori/list");
	}
	
	
	
}
