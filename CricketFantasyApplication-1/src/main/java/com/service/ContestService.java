package com.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.model.Contest;
import com.model.Team;

public interface ContestService {

	public List<Contest> getAllContests();
	
	 public Contest createContest(Contest contest);
	 public Contest addTeamToContest(long contestId, Team team);
	 public Contest declareWinner(long contestId, long teamId);

	public Contest updateContest(Contest contest);
	public void calculateScoresAndGenerateLeaderboard(Long contestId) throws NotFoundException;
}
