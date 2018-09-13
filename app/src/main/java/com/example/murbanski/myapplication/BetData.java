package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

public class BetData {

    @SerializedName("player")
    private String player;

    @SerializedName("bet")
    private Score bet;

    @SerializedName("points")
    private int points;

    public BetData() {
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Score getBet() {
        return bet;
    }

    public void setBet(Score bet) {
        this.bet = bet;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
