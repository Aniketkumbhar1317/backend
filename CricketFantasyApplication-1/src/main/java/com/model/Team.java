
package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


import com.enums.Position;


@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private int score;
    
    @ManyToMany
    private List<Player> players;
    
    ///////////////////

    
    @OneToMany(mappedBy = "team")
    private List<LeaderboardEntry> leaderboardEntries;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contest_id")
    private Contest contest;
    
    
    
    public Team(Long id, String name, List<Player> players) {
		super();
		this.id = id;
		this.name = name;
		this.players = players;
	}
    

	public Team(Long id, String name, List<Player> players, int score, Contest contest) {
		super();
		this.id = id;
		this.name = name;
		this.players = players;
		this.score = score;
		this.contest = contest;
	}


	public Team(Long id, String name, int score, List<Player> players, List<LeaderboardEntry> leaderboardEntries,
			Contest contest) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.players = players;
		this.leaderboardEntries = leaderboardEntries;
		this.contest = contest;
	}


	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Team(Long id, String name, List<Player> players, Contest contest) {
		super();
		this.id = id;
		this.name = name;
		this.players = players;
		this.contest = contest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	
	  public Contest getContest() {
		return contest;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}
	

	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public List<LeaderboardEntry> getLeaderboardEntries() {
		return leaderboardEntries;
	}


	public void setLeaderboardEntries(List<LeaderboardEntry> leaderboardEntries) {
		this.leaderboardEntries = leaderboardEntries;
	}


	public boolean isValidTeam() {
	        int wicketKeeperCount = countPlayersByPosition(Position.WICKET_KEEPER);
	        int bowlerCount = countPlayersByPosition(Position.BOWLER);
	        int batterCount = countPlayersByPosition(Position.BATSMAN);
	        int allRounderCount = countPlayersByPosition(Position.ALL_ROUNDER);
	        
	        return wicketKeeperCount >= 1 && bowlerCount >= 4 && batterCount >= 4 && allRounderCount >= 2;
	    }

	    // Helper method to count players by position
	    private int countPlayersByPosition(Position position) {
	        int count = 0;
	        for (Player player : players) {
	            if (player.getPosition() == position) {
	                count++;
	            }
	        }
	        return count;
	    }
}