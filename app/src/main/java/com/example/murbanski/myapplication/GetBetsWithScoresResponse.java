package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBetsWithScoresResponse {

    @SerializedName("result")
    private List<BetData> bets;

    public GetBetsWithScoresResponse() {
    }

    public List<BetData> getBets() {
        return bets;
    }

    public void setBets(List<BetData> bets) {
        this.bets = bets;
    }
}
