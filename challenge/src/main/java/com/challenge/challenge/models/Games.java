package com.challenge.challenge.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "games")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty("id")
    private Long id;

    @Column(nullable = false)
    @JsonProperty("hscore")
    private int hScore;

    @Column(nullable = false)
    @JsonProperty("round")
    private int round;

    @Column(nullable = false)
    @JsonProperty("is_grand_final")
    private int isGrandFinal;

    @Column(nullable = false)
    @JsonProperty("tz")
    private String tz;

    @Column(nullable = false)
    @JsonProperty("ateamid")
    private int aTeamId;

    @Column(nullable = false)
    @JsonProperty("ascore")
    private int aScore;

    @Column(nullable = false)
    @JsonProperty("roundname")
    private String roundName;

    @Column(nullable = false)
    @JsonProperty("hteamid")
    private int hTeamId;

    @Column(nullable = false)
    @JsonProperty("venue")
    private String venue;

    @Column(nullable = false)
    @JsonProperty("unixtime")
    private Long unixTime;

    @Column(nullable = false)
    @JsonProperty("hbehinds")
    private int hBehinds;

    @Column(nullable = false)
    @JsonProperty("abehinds")
    private int aBehinds;

    @Column(nullable = false)
    private int complete;

    @Column(nullable = false)
    @JsonProperty("winnerteamid")
    private int winnerTeamId;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Column(nullable = false)
    @JsonProperty("agoals")
    private int aGoals;

    @Column(nullable = false)
    @JsonProperty("hgoals")
    private int hGoals;

    @Column(nullable = false)
    @JsonProperty("timestr")
    private String timeStr;

    @Column(nullable = false)
    @JsonProperty("year")
    private int year;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    @Column(nullable = false)
    @JsonProperty("localtime")
    private LocalDateTime localTime;

    @Column(nullable = false)
    @JsonProperty("is_final")
    private int isFinal;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Teams homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Teams awayTeam;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Teams winnerTeam;

    private Integer homeTeamRank;

    private Integer awayTeamRank;



    public Games() {
    }

    public Games(Long id, int hScore, int round, int isGrandFinal, String tz, int aTeamId, int aScore, String roundName, int hTeamId, String venue, Long unixTime, int hBehinds, int aBehinds, int complete, int winnerTeamId, LocalDateTime date, int aGoals, int hGoals, String timeStr, int year, LocalDateTime updated, LocalDateTime localTime, int isFinal) {
        this.id = id;
        this.hScore = hScore;
        this.round = round;
        this.isGrandFinal = isGrandFinal;
        this.tz = tz;
        this.aTeamId = aTeamId;
        this.aScore = aScore;
        this.roundName = roundName;
        this.hTeamId = hTeamId;
        this.venue = venue;
        this.unixTime = unixTime;
        this.hBehinds = hBehinds;
        this.aBehinds = aBehinds;
        this.complete = complete;
        this.winnerTeamId = winnerTeamId;
        this.date = date;
        this.aGoals = aGoals;
        this.hGoals = hGoals;
        this.timeStr = timeStr;
        this.year = year;
        this.updated = updated;
        this.localTime = localTime;
        this.isFinal = isFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int gethScore() {
        return hScore;
    }

    public void sethScore(int hScore) {
        this.hScore = hScore;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getIsGrandFinal() {
        return isGrandFinal;
    }

    public void setIsGrandFinal(int isGrandFinal) {
        this.isGrandFinal = isGrandFinal;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public int getaTeamId() {
        return aTeamId;
    }

    public void setaTeamId(int aTeamId) {
        this.aTeamId = aTeamId;
    }


    public int getaScore() {
        return aScore;
    }

    public void setaScore(int aScore) {
        this.aScore = aScore;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public int gethTeamId() {
        return hTeamId;
    }

    public void sethTeamId(int hTeamId) {
        this.hTeamId = hTeamId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(Long unixTime) {
        this.unixTime = unixTime;
    }

    public int gethBehinds() {
        return hBehinds;
    }

    public void sethBehinds(int hBehinds) {
        this.hBehinds = hBehinds;
    }

    public int getaBehinds() {
        return aBehinds;
    }

    public void setaBehinds(int aBehinds) {
        this.aBehinds = aBehinds;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(int winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getaGoals() {
        return aGoals;
    }

    public void setaGoals(int aGoals) {
        this.aGoals = aGoals;
    }

    public int gethGoals() {
        return hGoals;
    }

    public void sethGoals(int hGoals) {
        this.hGoals = hGoals;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalDateTime localTime) {
        this.localTime = localTime;
    }

    public int getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(int isFinal) {
        this.isFinal = isFinal;
    }

    public Integer getHomeTeamRank() {
        return homeTeamRank;
    }

    public void setHomeTeamRank(Integer homeTeamRank) {
        this.homeTeamRank = homeTeamRank;
    }

    public Integer getAwayTeamRank() {
        return awayTeamRank;
    }

    public void setAwayTeamRank(Integer awayTeamRank) {
        this.awayTeamRank = awayTeamRank;
    }
}
