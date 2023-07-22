package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.LeaderboardRepository;
import com.model.LeaderboardEntry;
import com.service.ContestService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contests")
public class LeaderboardController {
    
     @Autowired	
	 LeaderboardRepository leaderboardEntryRepository;
    
     @Autowired
     ContestService contestService;
   

    @GetMapping("/leaderboard")
    public ResponseEntity<List<LeaderboardEntry>> getLeaderboard(@PathVariable Long contestId) {
        List<LeaderboardEntry> leaderboard = leaderboardEntryRepository.findByContestContestIdOrderByScoreDesc(contestId);
        return ResponseEntity.ok(leaderboard);
    }

  
}

