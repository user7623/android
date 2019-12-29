package com.example.mca2.Models;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GetDataService {

    @POST("/post")
    Call<List<Post>> getUsername(@Body User user);
}