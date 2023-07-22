package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "leaderboard")
public class LeaderboardEntry {

	     @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long leaderBoardId;

	    private int position;

	    @ManyToOne
	    @JoinColumn(name = "team_id")
	    private Team team;
	    
	    private int score;
	    
	      @ManyToOne
	  //  @JoinColumn(name = "contestId")
	    private Contest contest;


	public LeaderboardEntry() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public LeaderboardEntry(Long leaderBoardId, int position, Team team, int score, Contest contest) {
		super();
		this.leaderBoardId = leaderBoardId;
		this.position = position;
		this.team = team;
		this.score = score;
		this.contest = contest;
	}




	public Long getLeaderBoardId() {
		return leaderBoardId;
	}




	public void setLeaderBoardId(Long leaderBoardId) {
		this.leaderBoardId = leaderBoardId;
	}




	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public Contest getContest() {
		return contest;
	}


	public void setContest(Contest contest) {
		this.contest = contest;
	}

	
    
}
