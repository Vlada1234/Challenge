package com.challenge.challenge;

import com.challenge.challenge.components.DataDownloader;
import com.challenge.challenge.components.FetchDataFromApi;
import com.challenge.challenge.repository.GamesRepository;
import com.challenge.challenge.repository.StandingsRepository;
import com.challenge.challenge.repository.TeamsRepository;
import com.challenge.challenge.services.DataProcessingService;
import com.challenge.challenge.services.StandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

	private final DataDownloader dataDownloader;

	private final FetchDataFromApi fetchDataFromApi;

	private final TeamsRepository teamsRepository;

	private final StandingsRepository standingsRepository;

	private final GamesRepository gamesRepository;

	private final DataProcessingService dataProcessingService;

	private final StandingsService standingsService;



	@Autowired
	public ChallengeApplication(DataDownloader dataDownloader, FetchDataFromApi fetchDataFromApi, TeamsRepository teamsRepository, StandingsRepository standingsRepository, GamesRepository gamesRepository, DataProcessingService dataProcessingService, StandingsService standingsService) {
		this.dataDownloader = dataDownloader;
		this.fetchDataFromApi = fetchDataFromApi;
		this.teamsRepository = teamsRepository;
		this.standingsRepository = standingsRepository;
		this.gamesRepository = gamesRepository;
		this.dataProcessingService = dataProcessingService;
		this.standingsService = standingsService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		String apiUrl = "https://api.squiggle.com.au/?q=games&year=2022";

		standingsService.getAverageGoalsByRound(2022);



	}
}
