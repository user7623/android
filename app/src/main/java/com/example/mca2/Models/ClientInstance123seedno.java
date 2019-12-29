package com.example.mca2.Models;


import androidx.annotation.Nullable;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientInstance123seedno {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://5ddfd7adbb46ce001434bca8.mockapi.io/posts";
    @Nullable
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}