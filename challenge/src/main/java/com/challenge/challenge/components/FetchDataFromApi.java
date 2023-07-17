package com.challenge.challenge.components;

import com.challenge.challenge.GamesList;
import com.challenge.challenge.StandingsList;
import com.challenge.challenge.models.Games;
import com.challenge.challenge.models.Standings;
import com.challenge.challenge.repository.GamesRepository;
import com.challenge.challenge.repository.StandingsRepository;
import com.challenge.challenge.repository.TeamsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Component
public class FetchDataFromApi {

    private final GamesRepository gamesRepository;
    private final StandingsRepository standingsRepository;

    private final TeamsRepository teamsRepository;


    public FetchDataFromApi(GamesRepository gamesRepository, StandingsRepository standingsRepository, TeamsRepository teamsRepository) {
        this.gamesRepository = gamesRepository;
        this.standingsRepository = standingsRepository;
        this.teamsRepository = teamsRepository;
    }


    public void fetchDataFromApi() throws JsonProcessingException {
        String apiUrl = "https://api.squiggle.com.au/?q=games&year=2022";

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(apiUrl, String.class);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));
        objectMapper.registerModule(module);

        GamesList gamesList = objectMapper.readValue(jsonData, GamesList.class);


        Set<Integer> allRounds = new HashSet<>();

        // Add allRounds that exists in Set, so we can get standings for each round
        for (Games game : gamesList.getGames()) {
            gamesRepository.save(game);
            allRounds.add(game.getRound());

        }

        for (Integer round : allRounds) {
            System.out.println(round);
        }


            // Iterate through allRounds Set, and standings, so we can add standings for each round and save it in repository
            for (Integer round : allRounds) {
                String standingsApiUrl = "https://api.squiggle.com.au/?q=standings&year=2022&round=" + round ;
                String standingsJsonData = restTemplate.getForObject(standingsApiUrl, String.class);
                StandingsList standingsList = objectMapper.readValue(standingsJsonData, StandingsList.class);


                for (Standings standings : standingsList.getStandings()) {

                    // Create a separate object for each standing to get the standing for each round, not just the last one
                    Standings standingsEntity = new Standings();

                    standingsEntity.setRound(round);
                    standingsEntity.setLosses(standings.getLosses());
                    standingsEntity.setPts(standings.getPts());
                    standingsEntity.setGoalsFor(standings.getGoalsFor());
                    standingsEntity.setPercentage(standings.getPercentage());
                    standingsEntity.setRank(standings.getRank());
                    standingsEntity.setGoalsAgainst(standings.getGoalsAgainst());
                    standingsEntity.setPlayed(standings.getPlayed());
                    standingsEntity.setFor1(standings.getFor1());
                    standingsEntity.setDraws(standings.getDraws());
                    standingsEntity.setBehindsFor(standings.getBehindsFor());
                    standingsEntity.setBehindsAgainst(standings.getBehindsAgainst());
                    standingsEntity.setAgainst(standings.getAgainst());
                    standingsEntity.setWins(standings.getWins());
                    standingsEntity.setTeam(standings.getTeam());

                    standingsRepository.save(standingsEntity);



                }



            }
        }

}








