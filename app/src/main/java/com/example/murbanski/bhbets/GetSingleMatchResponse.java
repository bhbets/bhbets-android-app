package com.example.murbanski.bhbets;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSingleMatchResponse {

    @SerializedName("match")
    private MatchData match;

    public GetSingleMatchResponse() {
    }

    public MatchData getMatch() {
        return match;
    }

    public void setMatch(MatchData match) {
        this.match = match;
    }
}
