package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Contest;
import com.model.LeaderboardEntry;
import com.model.Player;
import com.model.Team;
import com.model.User;
import com.service.ContestService;
import com.service.LeaderboardService;
import com.service.PlayerService;
import com.service.TeamService;
import com.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class TestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	ContestService contestService;
	
	 @Autowired
     LeaderboardService leaderboardService;
	
	//register user
	
	 @PostMapping("/register")
	    public ResponseEntity<User> registerUser(@RequestBody User user) {
	        try {
	            User registeredUser = userService.registerUser(user);
	            return ResponseEntity.ok(registeredUser);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(null);
	        }
	    }
	
		
		      //loging user
		      
	       @GetMapping("/login") 
	       public ResponseEntity<User> loginUser(@RequestBody User user)
	       { 
	    	  
	    try {
	           User loggedInUser = userService.loginUser(user.getUserName(), user.getPassword()); 
	        
	           return  ResponseEntity.ok(loggedInUser); 
		  
	       } catch (Exception e)
	         { 
	    	  
	    	   return ResponseEntity.badRequest().body(null);
	    	  
	         } 
	       }
	       
	   
		 
	     //creating team
	       @PostMapping("/teams")
	       public ResponseEntity<Team> createTeam(@RequestBody Team team) {
	           try {
	               Team createdTeam = teamService.createTeam(team);
	               return ResponseEntity.ok(createdTeam);
	               
	           } catch (IllegalArgumentException e) {
	        	   System.out.println(e);
	               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(team);
	             
	           }
	       }
	       
	       @PostMapping("/createContest")
	       public ResponseEntity<Contest> createContest(@RequestBody Contest contest) {
	           Contest createdContest = contestService.createContest(contest);
	           return ResponseEntity.ok(createdContest);
	       }

	       @PutMapping("/{contestId}")
	       public ResponseEntity<Contest> updateContest(@PathVariable long contestId, @RequestBody Contest contest) {
	           contest.setContestId(contestId);
	           Contest updatedContest = contestService.updateContest(contest);
	           return ResponseEntity.ok(updatedContest);
	       }

	   

	       @PostMapping("/{contestId}/team")
	       public ResponseEntity<Contest> addTeamToContest(@PathVariable long contestId, @RequestBody Team team) {
	           Contest updatedContest = contestService.addTeamToContest(contestId, team);
	           return ResponseEntity.ok(updatedContest);
	       }
	       
	      

	       @PostMapping("/{contestId}/winner/{teamId}")
	       public ResponseEntity<Contest> declareWinner(
	               @PathVariable long contestId,
	               @PathVariable long teamId) {
	           Contest updatedContest = contestService.declareWinner(contestId, teamId);
	           return ResponseEntity.ok(updatedContest);
	       }
	       
	       @GetMapping("/getLeaderboardByContestId/{contestId}")
	       public List<LeaderboardEntry> getLeaderboardByContestId(@PathVariable Long contestId) {
	           return leaderboardService.getLeaderboardByContestId(contestId);
	       }

	     
	 
}