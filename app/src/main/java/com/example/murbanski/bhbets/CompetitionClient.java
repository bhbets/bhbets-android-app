package com.example.murbanski.bhbets;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompetitionClient implements CompetitionApi {

    private final OkHttpClient httpClient =
        new OkHttpClient.Builder()
            .addInterceptor(new AuthorizationHeaderInterceptor(AccessTokenStore.get()))
            .build();

    private final CompetitionApi instance =
        new Retrofit.Builder()
            .client(httpClient)
            .baseUrl("http://catheriann.nazwa.pl:8081")
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
