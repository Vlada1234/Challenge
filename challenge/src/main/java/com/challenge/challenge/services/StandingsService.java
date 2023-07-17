package com.challenge.challenge.services;

import com.challenge.challenge.models.Standings;
import com.challenge.challenge.repository.StandingsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class StandingsService {

    private final StandingsRepository standingsRepository;

    public StandingsService(StandingsRepository standingsRepository) {
        this.standingsRepository = standingsRepository;
    }

    // Get Standings by year and round input year, round.
    public List<String> getStandingsByYearAndRound(int year, int round) {
        List<Standings> standings = standingsRepository.findByYearAndRoundOrderByRank(year, round);
        List<String> standingsStrings = new ArrayList<>();

        for (Standings standing : standings) {
            String standingString = "Rank: " + standing.getRank() +
                    ", Name: " + standing.getTeam().getName() +
                    ", Points: " + standing.getPts();
            standingsStrings.add(standingString);
        }
        System.out.println(standingsStrings);

        return standingsStrings;
    }

    // Get Average Goals in round input year.
    public List<Object[]> getAverageGoalsByRound(int year) {
        List<Object[]> results = standingsRepository.findAverageGoalsByYear(year);

        for (Object[] result : results) {
            int roundNumber = (int) result[0];
            BigDecimal averageGoals = (BigDecimal) result[1];
            System.out.println("Round " + roundNumber + ": " + averageGoals);
            System.out.println("-------------------------------");
        }

        return results;
    }

}
