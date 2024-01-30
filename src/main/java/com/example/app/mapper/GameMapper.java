package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Game;

@Mapper
public interface GameMapper {
	
	List<Game> selectGame();
	Game selectById(Integer id);
	void update(Game game);

	

}
