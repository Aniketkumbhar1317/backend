package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlayerRepository;
import com.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService
{
	@Autowired
	PlayerRepository playerRepository;
	
	 public Player createPlayer(Player player) {
	        return playerRepository.save(player);
	    }
	    
	    public List<Player> getAllPlayers(Player p) {
	        return playerRepository.findAll();
	    }
	    
	    public Player getPlayerById(Long id) {
	        return playerRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));
	    }
	    
	    public void deletePlayer(Long id) {
	        playerRepository.deleteById(id);
	    }
}
