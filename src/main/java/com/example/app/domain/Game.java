package com.example.app.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Game {
	
	private Integer id;
	private LocalDate match;
	private String home;
	private String away;
	
	@NotBlank(message="得点を入力して下さい")
	private String score;
	
	@NotBlank(message="選択してください")
	private String result;
	
	@NotBlank(message="選手を選択してください")
	private String mom;
	private String comment;
	
	public void update(Game update) {
		this.score = update.getScore();
		this.result = update.getResult();
		this.mom = update.getMom();
		this.comment = update.getComment();
	}




}
