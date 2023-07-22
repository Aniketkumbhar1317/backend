package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LeaderboardRepository;
import com.model.LeaderboardEntry;

@Service
public class LeaderboardServiceImpl implements LeaderboardService{

	     @Autowired
	     LeaderboardRepository leaderboardEntryRepository;

	    public List<LeaderboardEntry> getLeaderboardByContestId(Long contestId) {
	        return leaderboardEntryRepository.findByContestContestIdOrderByScoreDesc(contestId);
	    }
	    

	    public void updateLeaderboardEntry(LeaderboardEntry leaderboardEntry) {
	        leaderboardEntryRepository.save(leaderboardEntry);
	    }
}
