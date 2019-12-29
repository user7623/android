package com.example.mca2.Service;

import com.example.mca2.Models.Comment;
import com.example.mca2.Models.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface IGetService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/id/comments")
    Call<List<Comment>> getComments();

}
