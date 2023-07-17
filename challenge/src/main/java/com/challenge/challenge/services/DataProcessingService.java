package com.challenge.challenge.services;

import com.challenge.challenge.models.Games;
import com.challenge.challenge.models.Standings;
import com.challenge.challenge.repository.GamesRepository;
import com.challenge.challenge.repository.StandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataProcessingService {

    private final GamesRepository gamesRepository;
    private final StandingsRepository standingsRepository;

    @Autowired
    public DataProcessingService(GamesRepository gamesRepository, StandingsRepository standingsRepository) {
        this.gamesRepository = gamesRepository;
        this.standingsRepository = standingsRepository;
    }

    // Append Rank of home and away team from previous round
    public void updateGameRanks() {
        Iterable<Games> games = gamesRepository.findAll();


        for (Games game : games) {
            int currentRound = game.getRound();

            if (currentRound > 1) {

                int previousRound = currentRound - 1;

                Standings homeTeamStandings = standingsRepository.findByTeam_IdAndRound(game.gethTeamId(), previousRound);
                Standings awayTeamStandings = standingsRepository.findByTeam_IdAndRound(game.getaTeamId(), previousRound);


                if (homeTeamStandings != null && awayTeamStandings != null) {
                    game.setHomeTeamRank(homeTeamStandings.getRank());
                    game.setAwayTeamRank(awayTeamStandings.getRank());
                }

            }
            else {
                game.setHomeTeamRank(null);
                game.setAwayTeamRank(null);
            }
        }
        gamesRepository.saveAll(games);
    }
}



