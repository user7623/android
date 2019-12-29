package com.example.mca2.Service;

import com.example.mca2.Models.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IPostService {

    //@POST("/posts")
    //Call<Post> createPost(@Body Post requestModel);
    @POST("/posts")
    Call<Post> createPost(@Body Post requestModel);
}
