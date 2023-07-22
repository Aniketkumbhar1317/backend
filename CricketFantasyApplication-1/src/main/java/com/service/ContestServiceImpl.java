package com.service;



import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.dao.ContestRepository;
import com.dao.TeamRepository;
import com.model.Contest;
import com.model.LeaderboardEntry;
import com.model.Player;
import com.model.Team;


@Service
public class ContestServiceImpl implements ContestService {
	
	@Autowired
	ContestRepository contestRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    public Contest createContest(Contest contest) {
        return contestRepository.save(contest);
    }
    
    public Contest updateContest(Contest contest) {
        return contestRepository.save(contest);
    }

    public Contest addTeamToContest(long contestId, Team team) {
        Contest contest = contestRepository.findById(contestId).orElse(null);

        team.setContest(contest);
        contest.getTeams().add(team);

        return contestRepository.save(contest);
    }
   
    public Contest declareWinner(long contestId, long teamId) {
        Contest contest = contestRepository.findById(contestId)
                .orElse(null);

        contest.setWinnerTeamId(teamId);

        return contestRepository.save(contest);
    }
    
    ///////////////////////
    public void calculateScoresAndGenerateLeaderboard(Long contestId) throws NotFoundException {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new NotFoundException());

        List<Team> teams = contest.getTeams();

        for (Team team : teams) {
            int totalScore = team.getPlayers().stream()
                    .mapToInt(Player::getPoints)
                    .sum();
            team.setScore(totalScore);
        }

        teamRepository.saveAll(teams);

        // Sort the teams based on their scores in descending order
        teams.sort(Comparator.comparingInt(Team::getScore).reversed());

        List<LeaderboardEntry> leaderboard = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            LeaderboardEntry entry = new LeaderboardEntry();
            entry.setPosition(i + 1);
            entry.setTeam(team);
            entry.setScore(team.getScore());
            leaderboard.add(entry);
        }

        contest.setLeaderboard(leaderboard);

        contestRepository.save(contest);
    }
    
    
	    }




