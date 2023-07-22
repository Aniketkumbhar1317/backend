package com.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.Position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlayerRepository;
import com.dao.TeamRepository;
import com.model.Player;
import com.model.Team;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PlayerRepository playerrepo;
	
	
	public Team createTeam(Team team) {
        List<String> playerNames = team.getPlayers().stream()
                .map(Player::getName)
                .collect(Collectors.toList());
        
        if (playerNames.size() != 11) {
            throw new IllegalArgumentException("A team must have exactly 11 players.");
        }

        List<Player> players;
		
			players = playerrepo.findAllByNameIn(playerNames);
		

        if (players.size() != 11) {
            throw new IllegalArgumentException("Invalid player names. Please provide existing player names.");
        }

        int batsmanCount = 0;
        int bowlerCount = 0;
        int allRounderCount = 0;
        int wicketKeeperCount = 0;

        for (Player player : players) {
            switch (player.getPosition()) {
                case BATSMAN:
                    batsmanCount++;
                    break;
                case BOWLER:
                    bowlerCount++;
                    break;
                case ALL_ROUNDER:
                    allRounderCount++;
                    break;
                case WICKET_KEEPER:
                    wicketKeeperCount++;
                    break;
            }
        }

        if (batsmanCount < 4 || bowlerCount < 4 || allRounderCount < 2 || wicketKeeperCount < 1) {
            throw new IllegalArgumentException("Invalid player composition. A team must have at least 4 batsmen, 4 bowlers, 2 all-rounders, and 1 wicket-keeper.");
        }

        team.setPlayers(players);

        return teamRepository.save(team);
    }
	//
	  public void calculateTeamScores() {
	        List<Team> teams = teamRepository.findAll();

	        for (Team team : teams) {
	            int totalScore = team.getPlayers().stream()
	                    .mapToInt(Player::getPoints)
	                    .sum();
	            team.setScore(totalScore);
	        }

	        teamRepository.saveAll(teams);
	    }
    
	
}
