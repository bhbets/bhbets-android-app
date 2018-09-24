package com.example.murbanski.myapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthorizationClient implements AuthorizationApi {

    private final AuthorizationApi instance =
            new Retrofit.Builder()
                .baseUrl("http://catheriann.nazwa.pl:8081")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthorizationApi.class);

    @Override
    public Call<ResponseBody> register(Credentials credentials) {
        return instance.register(credentials);
    }

    @Override
    public Call<LoginResponse> login(Credentials credentials) {
        return instance.login(credentials);
    }
}
