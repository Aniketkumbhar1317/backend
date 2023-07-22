package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.LeaderboardEntry;

public interface LeaderboardRepository extends JpaRepository<LeaderboardEntry, Long> {

    //List<LeaderboardEntry> findByContestIdOrderByScoreDesc(Long contestId);
  //  List<LeaderboardEntry> findByContest_ContestIdOrderByScoreDesc(Long contestId);

	//List<LeaderboardEntry> findByContestId(Long contestId);
	//List<LeaderboardEntry> findByContestcontestIdOrderByScoreDesc(Long contestId);
	
	 List<LeaderboardEntry> findByContestContestIdOrderByScoreDesc(Long contestId);

}
