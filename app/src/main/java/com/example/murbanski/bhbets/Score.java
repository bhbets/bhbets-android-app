package com.example.murbanski.bhbets;

import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("homeTeam")
    private int homeTeam;

    @SerializedName("awayTeam")
    private int awayTeam;

    public Score() {
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

}
