package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

public class MatchData {

    @SerializedName("id")
    private String id;

    @SerializedName("homeTeamName")
    private String homeTeam;

    @SerializedName("awayTeamName")
    private String awayTeam;

    @SerializedName("startDate")
    private String startDate;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
