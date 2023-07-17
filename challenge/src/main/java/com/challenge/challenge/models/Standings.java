package com.challenge.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

@Entity
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "standings")
public class Standings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("losses")
    private int losses;

    @Column(nullable = false)
    @JsonProperty("against")
    private int against;

    @Column(nullable = false)
    @JsonProperty("behinds_against")
    private int behindsAgainst;

    @Column(nullable = false)
    @JsonProperty("pts")
    private int pts;

    @Column(nullable = false)
    @JsonProperty("draws")
    private int draws;

    @Column(nullable = false)
    @JsonProperty("behinds_for")
    private int behindsFor;

    @Column(name = "`rank`", nullable = false)
    @JsonProperty("rank")
    private int rank;

    @Column(nullable = false)
    @JsonProperty("played")
    private int played;

    @Column(nullable = false)
    @JsonProperty("goals_for")
    private int goalsFor;

    @Column(nullable = false)
    @JsonProperty("percentage")
    private double percentage;

    @Column(name = "`for`", nullable = false,  columnDefinition = "INT NOT NULL")
    @JsonProperty("for")
    private int for1;

    @Column(nullable = false)
    @JsonProperty("goals_against")
    private int goalsAgainst;

    @Column(nullable = false)
    @JsonProperty("wins")
    private int wins;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonProperty("id")
    private Teams team;

    @Transient
    private String name;

    private int round;

    private int year;

    public Standings() {
    }

    public Standings(Long id, int losses, int against, int behindsAgainst, int pts, int draws, int behindsFor, int rank, int played, int goalsFor, double percentage, int for1, int goalsAgainst, int wins) {
        this.id = id;
        this.losses = losses;
        this.against = against;
        this.behindsAgainst = behindsAgainst;
        this.pts = pts;
        this.draws = draws;
        this.behindsFor = behindsFor;
        this.rank = rank;
        this.played = played;
        this.goalsFor = goalsFor;
        this.percentage = percentage;
        this.for1 = for1;
        this.goalsAgainst = goalsAgainst;
        this.wins = wins;
    }

    public Standings(Standings standings) {
    }


    public Long getStandingsId() {
        return id;
    }

    public void setStandingsId(Long id) {
        this.id = id;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }

    public int getBehindsAgainst() {
        return behindsAgainst;
    }

    public void setBehindsAgainst(int behindsAgainst) {
        this.behindsAgainst = behindsAgainst;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getBehindsFor() {
        return behindsFor;
    }

    public void setBehindsFor(int behindsFor) {
        this.behindsFor = behindsFor;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getFor1() {
        return for1;
    }

    public void setFor1(int for1) {
        this.for1 = for1;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
