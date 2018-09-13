package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSingleMatchResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("status")
    private String status;

    @SerializedName("homeTeamName")
    private String homeTeam;

    @SerializedName("awayTeamName")
    private String awayTeam;

    @SerializedName("startDate")
    private String startDate;

    @SerializedName("bet")
    private Score bet;

    @SerializedName("result")
    private Score result;

    @SerializedName("points")
    private int points;

    @SerializedName("otherBets")
    private List<BetData> otherBets;

    public GetSingleMatchResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Score getBet() {
        return bet;
    }

    public void setBet(Score bet) {
        this.bet = bet;
    }

    public Score getResult() {
        return result;
    }

    public void setResult(Score result) {
        this.result = result;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<BetData> getOtherBets() {
        return otherBets;
    }

    public void setOtherBets(List<BetData> otherBets) {
        this.otherBets = otherBets;
    }

    // konstruktor, gettery, settery
}
