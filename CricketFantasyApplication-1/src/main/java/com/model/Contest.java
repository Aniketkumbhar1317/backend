package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contests")
public class Contest {
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long contestId;

	    private String name;

	  ////////////////////////
	    @OneToMany(mappedBy = "contest")
	    private List<LeaderboardEntry> leaderboard;
	    
	    
	    @OneToMany(mappedBy = "contest", cascade = CascadeType.ALL)
	    private List<Team> teams;
	    
	    @Column(name = "winner_team_id")
	    private Long winnerTeamId;

		public Contest() {
			super();
			
		}

		public Long getContestId() {
			return contestId;
		}



		public void setContestId(Long contestId) {
			this.contestId = contestId;
		}



		public Contest(Long contestId, String name, List<Team> teams, Long winnerTeamId) {
			super();
			this.contestId = contestId;
			this.name = name;
			this.teams = teams;
			this.winnerTeamId = winnerTeamId;
		}



		public Contest(Long contestId, String name, List<LeaderboardEntry> leaderboard, List<Team> teams,
				Long winnerTeamId) {
			super();
			this.contestId = contestId;
			this.name = name;
			this.leaderboard = leaderboard;
			this.teams = teams;
			this.winnerTeamId = winnerTeamId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Team> getTeams() {
			return teams;
		}

		public void setTeams(List<Team> teams) {
			this.teams = teams;
		}

		public Long getWinnerTeamId() {
			return winnerTeamId;
		}

		public void setWinnerTeamId(Long winnerTeamId) {
			this.winnerTeamId = winnerTeamId;
		}

		public List<LeaderboardEntry> getLeaderboard() {
			return leaderboard;
		}

		public void setLeaderboard(List<LeaderboardEntry> leaderboard) {
			this.leaderboard = leaderboard;
		}

		
	    
	    
}
