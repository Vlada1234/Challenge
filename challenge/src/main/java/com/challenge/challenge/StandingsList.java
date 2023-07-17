package com.challenge.challenge;

import com.challenge.challenge.models.Standings;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingsList {
    private List<Standings> standings;

    public List<Standings> getStandings() {
        return standings;
    }

    public void setStandings(List<Standings> standings) {
        this.standings = standings;
    }
}
