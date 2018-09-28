package com.example.murbanski.bhbets;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompetitionClient implements CompetitionApi {

    private final CompetitionApi instance =
            new Retrofit.Builder()
                    .baseUrl("http://5b59a29cf294400014c9b82a.mockapi.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CompetitionApi.class);

    @Override
    public Call<GetMatchesResponse> getMatches() {
        return instance.getMatches();
    }

    @Override
    public Call<GetSingleMatchResponse> getMatch(String matchId) {
        return instance.getMatch(matchId);
    }

    @Override
    public Call<GetPointsResponse> getPoints() {
        return instance.getPoints();
    }
}
