package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Member;
import com.example.app.mapper.MemberMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberMapper mapper;
	
	@GetMapping("/members")
	public String list(Model model)throws Exception{
		model.addAttribute("members",mapper.selectMembers());
		return "members";
	}
	@GetMapping("/add")
	public String add(Model model)throws Exception{
		Member member = new Member();
		model.addAttribute("member",member);
		return "memberAdd";
	}
	@PostMapping("/add")
	public String add(@Valid Member member,Errors errors)throws Exception{
		if(errors.hasErrors()) {
			return "memberAdd";
		}
		mapper.addMember(member);
		return "redirect:/members";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes rd)throws Exception {
	mapper.deleteMember(id);
	rd.addFlashAttribute("statusMessage", "選手情報を削除しました。");
	return "redirect:/members";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
