package com.example.mca2.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService {
    public static Retrofit retrofitClient;

    public static IPostService _postService;

    public static void initalizeRetrofit()
    {
        retrofitClient = new Retrofit.Builder()
                .baseUrl("http://5ddfd7adbb46ce001434bca8.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        _postService = retrofitClient.create(IPostService.class);
    }

}
