package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.LeaderboardRepository;
import com.model.LeaderboardEntry;
import com.model.Player;
import com.model.User;
import com.service.ContestService;
import com.service.LeaderboardService;
import com.service.PlayerService;
import com.service.TeamService;
import com.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	  
	 @Autowired	
	 LeaderboardRepository leaderboardEntryRepository;
    
     @Autowired
     ContestService contestService;
     
 	@Autowired
 	UserService userService;
 	
 	@Autowired
 	PlayerService playerService;
 	
 	@Autowired
 	TeamService teamService;
 	
 	 @Autowired
      LeaderboardService leaderboardService;
 
 	 User user;
     
     //adding player
	 
     @PostMapping("/addPlayer")
     public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        
		try {
			Player 	createdPlayer = playerService.createPlayer(player);
			return ResponseEntity.ok(createdPlayer);
		} 
		catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
			
		}
          
		
         
     }
	
	@PostMapping("/calculate")
	    public ResponseEntity<Void> calculateScoresAndGenerateLeaderboard(@PathVariable Long contestId) throws NotFoundException {
	        contestService.calculateScoresAndGenerateLeaderboard(contestId);
	        return ResponseEntity.ok().build();
	    }
	
	 @PostMapping("/calculate-scores")
     public ResponseEntity<Void> calculateTeamScores() {
         teamService.calculateTeamScores();
         return ResponseEntity.ok().build();
     }

	 //
	  @PostMapping("/updateLeaderboard")
      public ResponseEntity<String> updateLeaderboardEntry(@RequestBody LeaderboardEntry leaderboardEntry) {
          leaderboardService.updateLeaderboardEntry(leaderboardEntry);
          return ResponseEntity.ok("Leaderboard entry updated successfully");
      }
	System.out.println("hello world");
}
