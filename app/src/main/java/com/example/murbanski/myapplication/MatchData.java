package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

public class MatchData {

    @SerializedName("id_match")
    private String id;

    @SerializedName("team_a")
    private String homeTeam;

    @SerializedName("team_b")
    private String awayTeam;

    public MatchData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
}
