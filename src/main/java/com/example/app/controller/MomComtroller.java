package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.mapper.MomMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MomComtroller {
	
	private final MomMapper mapper;
	
	@GetMapping("/mom")
	public String showMom(Model model) {
		model.addAttribute("mom",mapper.selectByMom());
		return "mom";
	}
	
	

}
