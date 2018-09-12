package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

public class BetData {

    /*@SerializedName("login")
    private String login;*/

    @SerializedName("result")
    Result result;

    public class Result {

        @SerializedName("homeTeam")
        private String homeTeamBet;

        @SerializedName("awayTeam")
        private String awayTeamBet;
    }

    @SerializedName("homeTeamName")
    private String homeTeamName;

    @SerializedName("awayTeamName")
    private String awayTeamName;

    @SerializedName("homeTeam")
    private String homeTeamResult;

    @SerializedName("awayTeam")
    private String awayTeamResult;

    public BetData() {
    }

    /*public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }*/

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getHomeTeamResult() {
        return homeTeamResult;
    }

    public void setHomeTeamResult(String homeTeamResult) {
        this.homeTeamResult = homeTeamResult;
    }

    public String getAwayTeamResult() {
        return awayTeamResult;
    }

    public void setAwayTeamResult(String awayTeamResult) {
        this.awayTeamResult = awayTeamResult;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
