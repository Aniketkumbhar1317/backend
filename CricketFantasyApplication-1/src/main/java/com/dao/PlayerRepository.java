package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	List<Player> findAllByNameIn(List<String> playerNames);
}
