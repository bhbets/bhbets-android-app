package com.example.murbanski.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPointsResponse {

    @SerializedName("players")
    private List<PointData> players;

    public GetPointsResponse() {
    }

    public List<PointData> getPoints() {
        return players;
    }

    public void setMatches(List<MatchData> matches) {
        this.players = players;
    }
}
