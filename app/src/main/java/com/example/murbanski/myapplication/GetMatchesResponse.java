package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMatchesResponse {

    @SerializedName("result")
    private List<MatchData> matches;

    public GetMatchesResponse() {
    }

    public List<MatchData> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchData> matches) {
        this.matches = matches;
    }
}
