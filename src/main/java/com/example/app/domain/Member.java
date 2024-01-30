package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Member {
	
	private Integer id;
	
	@NotNull(message="背番号を入力して下さい")
	private Integer number;
	
	@NotBlank(message="名前を入力して下さい")
	private String name;
	
	
}
