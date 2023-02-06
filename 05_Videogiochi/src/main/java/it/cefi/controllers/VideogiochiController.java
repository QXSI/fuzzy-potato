package it.cefi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.cefi.models.Videogioco;
import it.cefi.services.SviluppatoriService;
import it.cefi.services.VideogiochiService;

@Controller
public class VideogiochiController {
	
	@Autowired
	public VideogiochiService videogiochiService;
	
	@Autowired
	public SviluppatoriService sviluppatoriService;
	
	@GetMapping("/videogiochi/list")
	public String list(Model model) {
		model.addAttribute("videogioco", new Videogioco());
		model.addAttribute("videogiochi", videogiochiService.getVideogiochi());
		return "videogiochi/list";
	}
	
	@PostMapping("/videogiochi/list")
	public String list(@ModelAttribute Videogioco videogioco, Model model) {
		model.addAttribute("videogioco", new Videogioco());
		model.addAttribute("videogiochi", videogiochiService.searchvideogiochi(videogioco.getTitolo()));
		return "videogiochi/list";
	}
	
	@GetMapping("/videogiochi/edit")
	public String edit(Model model) {
		model.addAttribute("videogioco", new Videogioco());
		model.addAttribute("sviluppatori", sviluppatoriService.getSviluppatori());
		return "videogiochi/edit";
	}
	
	@GetMapping("/videogiochi/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("videogioco", videogiochiService.getVideogioco(id));
		model.addAttribute("sviluppatori", sviluppatoriService.getSviluppatori());
		return "videogiochi/edit";
	}
	
	@PostMapping("/videogiochi/edit")
	public ModelAndView edit(@ModelAttribute Videogioco videogioco) {
		videogiochiService.saveVideogioco(videogioco);
		return new ModelAndView ("redirect:/videogiochi/list");
	}
	
	@GetMapping("/videogiochi/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		model.addAttribute("videogioco", videogiochiService.getVideogioco(id));
		return "videogiochi/delete";
	}
	
	@PostMapping("/videogiochi/delete")
	public ModelAndView delete(@ModelAttribute Videogioco videogioco) {
		videogiochiService.deleteVideogioco(videogioco.getId());
		return new ModelAndView("redirect:/videogiochi/list");
	}
	
}
