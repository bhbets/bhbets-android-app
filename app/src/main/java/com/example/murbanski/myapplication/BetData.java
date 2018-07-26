package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

public class BetData {

    @SerializedName("login")
    private String login;

    @SerializedName("bet_a")
    private String homeTeamBet;

    @SerializedName("bet_b")
    private String awayTeamBet;

    public BetData() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHomeTeamBet() {
        return homeTeamBet;
    }

    public void setHomeTeamBet(String homeTeamBet) {
        this.homeTeamBet = homeTeamBet;
    }

    public String getAwayTeamBet() {
        return awayTeamBet;
    }

    public void setAwayTeamBet(String awayTeamBet) {
        this.awayTeamBet = awayTeamBet;
    }
}
