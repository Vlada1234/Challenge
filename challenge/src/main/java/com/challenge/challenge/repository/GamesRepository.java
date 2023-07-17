package com.challenge.challenge.repository;

import com.challenge.challenge.models.Games;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Games g " +
           "SET g.homeTeam = (SELECT t FROM Teams t WHERE t.id = g.hTeamId), " +
          "g.awayTeam = (SELECT t FROM Teams t WHERE t.id = g.aTeamId), " +"g.winnerTeam = (SELECT t FROM Teams t WHERE t.id = g.winnerTeamId)")
    void updateGamesTableFromTeams();

}
