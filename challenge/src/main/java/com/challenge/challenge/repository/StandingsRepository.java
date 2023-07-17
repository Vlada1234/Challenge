package com.challenge.challenge.repository;

import com.challenge.challenge.models.Standings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StandingsRepository extends JpaRepository<Standings, Long> {



    Standings findByTeam_IdAndRound(int teamId, int round);

    List<Standings> findByYearAndRoundOrderByRank(int year, int round);

    @Query(value = "SELECT  s.round AS round, AVG(s.goals_for) AS averageGoals " +
            "FROM Standings s " +
            "WHERE s.year = :year " +
            "GROUP BY s.round " +
            "ORDER BY s.round", nativeQuery = true)
    List<Object[]> findAverageGoalsByYear(@Param("year") int year);





}
