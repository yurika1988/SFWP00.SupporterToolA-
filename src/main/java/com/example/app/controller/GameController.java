package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Game;
import com.example.app.mapper.GameMapper;
import com.example.app.mapper.MemberMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GameController {

	private final GameMapper gameMapper;
	private final MemberMapper memberMapper;

	public String memberName(Model model) {
		model.addAttribute("member", memberMapper.selectMembers());
		return "gameUpdate";
	}

	@GetMapping("/games")
	public String list(Model model) throws Exception {
		model.addAttribute("games", gameMapper.selectGame());
		return "games";
	}

	@GetMapping("/update/{id}")
	public String editGet(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("member", memberMapper.selectMembers());
		model.addAttribute("game", gameMapper.selectById(id));
		return "gameUpdate";

	}

	@PostMapping("/update/{id}")
	public String editPost(@PathVariable Integer id, @Valid Game game, Errors errors, RedirectAttributes rd,
			Model model) throws Exception {
		if (errors.hasErrors()) {
			model.addAttribute("member",memberMapper.selectMembers());
			return "gameUpdate";
		}
		game.setId(id); // 更新に必要な会員ID をセット
		gameMapper.update(game);
		rd.addFlashAttribute("statusMessage", "試合情報を更新しました。");
		return "redirect:/games";
	}
}
