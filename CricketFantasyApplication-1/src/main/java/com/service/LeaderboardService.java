package com.service;

import java.util.List;

import com.model.LeaderboardEntry;

public interface LeaderboardService {

	public List<LeaderboardEntry> getLeaderboardByContestId(Long contestId);
	
	  public void updateLeaderboardEntry(LeaderboardEntry leaderboardEntry);
}
