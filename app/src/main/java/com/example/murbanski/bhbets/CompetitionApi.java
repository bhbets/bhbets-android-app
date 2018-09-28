package com.example.murbanski.bhbets;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CompetitionApi {

    @GET("/matches")
    Call<GetMatchesResponse> getMatches();

    @GET("/matches/{matchId}")
    Call<GetSingleMatchResponse> getMatch(@Path("matchId") String matchId);

    @GET("/points")
    Call<GetPointsResponse> getPoints();
}
