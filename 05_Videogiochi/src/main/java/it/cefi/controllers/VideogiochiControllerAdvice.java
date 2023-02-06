package it.cefi.controllers;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class VideogiochiControllerAdvice {
	
	@ExceptionHandler(value = NoSuchElementException.class)
	@GetMapping("/error")
	public ModelAndView noSuchElement(NoSuchElementException e) {
		ModelAndView modelAndView = new ModelAndView("nosuchelement");
		modelAndView.addObject("exception", e.getMessage());
		return modelAndView;
	}
	
}
