package com.example.mca2.Models;

import android.widget.ImageView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post extends User {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("userAvatar")
    @Expose
    private String userAvatar;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("details")
    @Expose
    private String details;

    public Post (String userName, int likes){
        this.userName = userName;
        this.likes = likes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    /*int numberOfLikes;
    int numberOfComments;
    ImageView postImage;
    String description;
    String id;

    public Post(int numberOfLikes, int numberOfComments, String description, String id){
        this.numberOfComments = numberOfComments;
        this.numberOfLikes = numberOfLikes;
        this.description = description;
        this.id = id;
    }
    public int getNumberOfLikes(){
        return numberOfLikes;
    }
    public int getNumberOfComments(){
        return numberOfComments;
    }

     */
}
