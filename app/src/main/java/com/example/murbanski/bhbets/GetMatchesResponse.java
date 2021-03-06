package com.example.murbanski.bhbets;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMatchesResponse {

    @SerializedName("matches")
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
