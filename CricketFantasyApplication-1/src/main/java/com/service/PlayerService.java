package com.service;

import java.util.List;

import com.model.Player;

public interface PlayerService {
	
	 public Player createPlayer(Player player);
	 
	 public List<Player> getAllPlayers(Player p);
	
	 public Player getPlayerById(Long id);

	 public void deletePlayer(Long id);
	 
	
}
