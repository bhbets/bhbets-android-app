package com.example.murbanski.bhbets;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthorizationApi {

    @POST("/register")
    Call<ResponseBody> register(@Body Credentials credentials);

    @POST("/login")
    Call<LoginResponse> login(@Body Credentials credentials);
}
